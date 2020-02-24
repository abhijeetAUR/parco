package com.hexagon.parcodriver;

import android.content.Intent;
import android.os.Build;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hexagon.parcodriver.Utils.AndroidUtilities;
import com.hexagon.parcodriver.Utils.FileLog;
import com.hexagon.parcodriver.Utils.TransitionUtil;


public class BaseActivity extends AppCompatActivity {


    public void changeInputType(int type) {
        getWindow().setSoftInputMode(type);
    }

    public void replaceFragment(BaseFragment fragment) {
        replaceFragment(fragment, false, true, false);
    }

    public void replaceFragment(BaseFragment fragment, boolean isAdd) {
        replaceFragment(fragment, isAdd, true, false);
    }

    public void replaceFragment(BaseFragment fragment, boolean isAdd, boolean addtobs) {
        replaceFragment(fragment, isAdd, addtobs, false);
    }

    public void replaceFragment(BaseFragment fragment, boolean isAdd, boolean addtobs, boolean forceWithoutAnimation) {
        replaceFragment(fragment, isAdd, addtobs, forceWithoutAnimation, null);
    }

    public void replaceFragment(BaseFragment fragment, boolean isAdd, boolean addtobs, boolean forceWithoutAnimation, Transition transition) {
        //to do in child activity
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
            ft.add(android.R.id.content, fragment, tag);
        else
            ft.replace(android.R.id.content, fragment, tag);
        if (addtobs)
            ft.addToBackStack(tag);
        ft.commitAllowingStateLoss();

    }


    public void hideSystemUI() {
        if (AndroidUtilities.isAndroid5())
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    public void showSystemUI() {
        if (AndroidUtilities.isAndroid5())
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            );
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setStatusBarColor(int color) {
        getWindow().setStatusBarColor(color);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null)
            handleIntent(intent);
    }

    protected void handleIntent(Intent intent) {

    }

    @Override
    public void onBackPressed() {

        FileLog.e(getSupportFragmentManager().getBackStackEntryCount()+"===");
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getCurrentFragment().onBackPressed();
        } else
            finish();
    }


    public BaseFragment getCurrentFragment() {
        return (BaseFragment) getSupportFragmentManager().findFragmentById(android.R.id.content);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        try {
            for (Fragment fragment : getSupportFragmentManager().getFragments())
                fragment.onLowMemory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeFragments(int no) {
        try {

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(fragmentManager.getBackStackEntryAt(
                    fragmentManager.getBackStackEntryCount() - no).getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
