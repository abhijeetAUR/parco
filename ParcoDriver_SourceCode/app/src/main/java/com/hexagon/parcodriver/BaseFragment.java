package com.hexagon.parcodriver;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hexagon.parcodriver.Utils.AndroidUtilities;
import com.hexagon.parcodriver.Utils.FileLog;
import com.hexagon.parcodriver.storage.PreferenceStore;


@SuppressLint("ValidFragment")
public class BaseFragment extends Fragment {
    protected BaseActivity activity;
    protected String TAG = "parco";
    protected ImageButton slider;
    protected ImageButton backBtn;
    protected Toolbar toolbar;
    protected PreferenceStore preferenceStore;
    protected TextView toolbarTitle;
    protected ImageButton i_image;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (BaseActivity) getActivity();
        activity.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.white)));
        TAG = getClass().getSimpleName();
        preferenceStore = PreferenceStore.getInstance();
        manageActivityToolbar();
    }


    public void onBackPressed() {
        try {
            AndroidUtilities.hideKeyboard(getView());
            getFragmentManager().popBackStack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }


    public void onWindowFocusChanged(boolean hasFocus) {

    }

    public void lockDrawer(boolean isLock) {
        if (activity instanceof MainActivity)
            ((MainActivity) activity).lockDrawer(isLock);

    }

    public void statusBarColor(int color) {

        if (activity instanceof MainActivity)
            ((MainActivity) activity).statusBarColor(color);

    }


    public void manageActivityToolbar() {
        try {
            if (activity instanceof MainActivity) {
                toolbar = ((MainActivity) activity).toolbar;
                toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbarTitle);
                slider = (ImageButton) toolbar.findViewById(R.id.sliderBtn);
                backBtn = (ImageButton) toolbar.findViewById(R.id.backBtn);
                i_image = (ImageButton) toolbar.findViewById(R.id.i_image);



            }

        } catch (Exception e) {
            FileLog.e(e);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

}
