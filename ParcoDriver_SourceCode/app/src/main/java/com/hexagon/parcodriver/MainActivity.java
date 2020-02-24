package com.hexagon.parcodriver;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hexagon.parcodriver.Utils.AndroidUtilities;
import com.hexagon.parcodriver.Utils.FileLog;
import com.hexagon.parcodriver.Utils.TransitionUtil;
import com.hexagon.parcodriver.adapter.NavigationAdapter;
import com.hexagon.parcodriver.fragment.HistoryFragment;
import com.hexagon.parcodriver.fragment.HomeFragment;
import com.hexagon.parcodriver.fragment.LanguageSelectFragment;
import com.hexagon.parcodriver.fragment.LoginFragment;
import com.hexagon.parcodriver.fragment.NotificationFragment;
import com.hexagon.parcodriver.fragment.SettingFragment;
import com.hexagon.parcodriver.model.NevigationItem;


public class MainActivity extends BaseActivity implements NavigationAdapter.NavigationClickListner {

    public Toolbar toolbar;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private boolean mSlideState;
    private RecyclerView navigation_view;
    private NavigationAdapter navigationAdapter;
    public Fragment currentFragment;
    private HomeFragment homeFragment;
    private static int selectedTab = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment( new LanguageSelectFragment());
//            currentFragment = homeFragment;
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageButton sliderBtn = (ImageButton) findViewById(R.id.sliderBtn);
        ImageButton backBtn = (ImageButton) findViewById(R.id.backBtn);
        ImageButton notification = (ImageButton) findViewById(R.id.i_image);
        ImageButton close = (ImageButton) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.closeDrawer(Gravity.LEFT);
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);




        toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        ) {

            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
                mSlideState = false;
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
                mSlideState = true;
            }
        };


        toggle.setDrawerIndicatorEnabled(false);
        sliderBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                AndroidUtilities.hideKeyboard(v);
                if (mSlideState) {
                    drawer.closeDrawer(Gravity.START);
                } else {
                    drawer.openDrawer(Gravity.START);
                }
            }
        });

        drawer.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                return false;
            }
        });

        toggle.syncState();
        navigation_view = (RecyclerView) findViewById(R.id.navigation_view);
        navigation_view.setLayoutManager(new LinearLayoutManager(this));
        navigationAdapter = new NavigationAdapter(this,MainActivity.this);
        navigation_view.setAdapter(navigationAdapter);

        TypedArray groupIcons = getResources().obtainTypedArray(R.array.icons);
        String[] groupTitles = getResources().getStringArray(R.array.icons_name);



        for (int i = 0; i < groupIcons.length(); i++) {
            navigationAdapter.addItem(new NevigationItem(groupTitles[i], getResources().getDrawable(groupIcons.getResourceId(i, -1))));
        }




        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                AndroidUtilities.hideKeyboard(v);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              replaceFragment(new NotificationFragment());
                AndroidUtilities.hideKeyboard(v);
            }
        });




    }



    @Override
    public void replaceFragment(BaseFragment fragment, boolean isAdd, boolean addtobs, boolean forceWithoutAnimation, Transition transition) {
        if (fragment == null)
            return;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        String tag = fragment.getClass().getSimpleName();
        ft.setAllowOptimization(true);
        if (!forceWithoutAnimation) {
            if (AndroidUtilities.isAndroid5()) {
                if (transition != null) {
                    fragment.setEnterTransition(transition);
                } else {
                    fragment.setEnterTransition(TransitionUtil.slide(Gravity.RIGHT));
                }
            } else {
                ft.setCustomAnimations(R.anim.pull_in_right, R.anim.push_out_left, R.anim.pull_in_left, R.anim.push_out_right);
            }
        }
        if (isAdd)
            ft.add(R.id.frame, fragment, tag);
        else
            ft.replace(R.id.frame, fragment, tag);
        if (addtobs)
            ft.addToBackStack(tag);
        ft.commitAllowingStateLoss();

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        try {
            if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
                getCurrentFragment().onWindowFocusChanged(hasFocus);
            }
        } catch (Exception e) {
            FileLog.e("window focus changed", String.valueOf(hasFocus));
        }

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);

        int backEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if ((backEntryCount > 1)) {
            getCurrentFragment().onBackPressed();
        } else
            super.onBackPressed();


    }


    @Override
    public BaseFragment getCurrentFragment() {
        return (BaseFragment) getSupportFragmentManager().findFragmentById(R.id.frame);
    }

    public void lockDrawer(boolean isLock) {
        if (isLock)
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        else
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    public void statusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(color);
        }
    }

    @Override
    public void itemOnClickListner(int position) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);

        switch (position) {

//            case NavigationItem.HOME:
//                replaceFragment(new HomeFragment());
////                Toast.makeText(getApplicationContext(),"Under Development", Toast.LENGTH_SHORT).show();
//                break;
            case NavigationItem.HISTORY:
                replaceFragment(new HistoryFragment());
//                Toast.makeText(getApplicationContext(),"Under Development", Toast.LENGTH_SHORT).show();

                break;

            case NavigationItem.SETTING:
                replaceFragment(new SettingFragment());
//                Toast.makeText(getApplicationContext(),"Under Development", Toast.LENGTH_SHORT).show();

                break;

            case NavigationItem.LOGOUT:
                removeFragments(getFragmentManager().getBackStackEntryCount());
               replaceFragment(new LanguageSelectFragment(),false,false,false);
//                Toast.makeText(getApplicationContext(),"Under Development", Toast.LENGTH_SHORT).show();

                break;


        }

    }

    public interface NavigationItem {
        int HISTORY = 0;
        int SETTING = 1;
        int LOGOUT = 2;


    }

}
