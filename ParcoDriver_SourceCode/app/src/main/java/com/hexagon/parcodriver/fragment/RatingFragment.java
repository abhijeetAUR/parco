package com.hexagon.parcodriver.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hexagon.parcodriver.BaseFragment;
import com.hexagon.parcodriver.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RatingFragment extends BaseFragment implements View.OnClickListener{


    private TextView procced;

    public RatingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setToolbar();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setListner();
    }

    private void setListner() {
        procced.setOnClickListener(this);
    }

    private void initView(View view) {
        procced=(TextView)view.findViewById(R.id.procced);
    }

    private void setToolbar() {

        try {

            lockDrawer(true);
            if (toolbar != null) {
                toolbar.setVisibility(View.VISIBLE);
//                activity.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(activity.getResources().getColor(R.color.transparent)));
                FrameLayout frameLayout = (FrameLayout) toolbar.getChildAt(0);
                for (int i = 0; i < frameLayout.getChildCount(); i++)
                    frameLayout.getChildAt(i).setVisibility(View.GONE);


            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.procced:

                activity.replaceFragment(new HomeFragment());

                break;
        }
    }
}
