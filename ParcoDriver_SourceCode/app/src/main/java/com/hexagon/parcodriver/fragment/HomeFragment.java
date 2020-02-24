package com.hexagon.parcodriver.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hexagon.parcodriver.BaseFragment;
import com.hexagon.parcodriver.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener{


    private FrameLayout accept_btn;
    private LinearLayout linner_order_view;
    private LinearLayout linner_Secound;
    private TextView collectCar;
    private LinearLayout linner_Third;
    private TextView complete_Parking;
    private LinearLayout linner_Fourth;
    private TextView complete_additional;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setToolbar();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intitView(view);
        setlistner();
    }

    private void setlistner() {
        accept_btn.setOnClickListener(this);
        linner_order_view.setOnClickListener(this);
        linner_Secound.setOnClickListener(this);
        collectCar.setOnClickListener(this);
        linner_Third.setOnClickListener(this);
        complete_Parking.setOnClickListener(this);
        linner_Fourth.setOnClickListener(this);
        complete_additional.setOnClickListener(this);
        linner_order_view.setVisibility(View.VISIBLE);
    }

    private void intitView(View view) {
        accept_btn=(FrameLayout)view.findViewById(R.id.accept_btn);
        linner_order_view=(LinearLayout)view.findViewById(R.id.linner_order_view);
        linner_Secound=(LinearLayout)view.findViewById(R.id.linner_Secound);
        linner_Third=(LinearLayout)view.findViewById(R.id.linner_Third);
        collectCar=(TextView)view.findViewById(R.id.collectCar);
        complete_Parking=(TextView)view.findViewById(R.id.complete_Parking);
        linner_Fourth=(LinearLayout)view.findViewById(R.id.linner_Fourth);
        complete_additional=(TextView)view.findViewById(R.id.complete_additional);
    }

    private void setToolbar() {

        try {

            lockDrawer(false);
            if (toolbar != null) {
                toolbar.setVisibility(View.VISIBLE);
//                activity.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(activity.getResources().getColor(R.color.transparent)));
                FrameLayout frameLayout = (FrameLayout) toolbar.getChildAt(0);
                for (int i = 0; i < frameLayout.getChildCount(); i++)
                    frameLayout.getChildAt(i).setVisibility(View.GONE);

                slider.setVisibility(View.VISIBLE);
                toolbarTitle.setVisibility(View.VISIBLE);
                i_image.setVisibility(View.VISIBLE);
                toolbarTitle.setText("parco");
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.accept_btn:

                linner_order_view.setVisibility(View.GONE);
                linner_Secound.setVisibility(View.VISIBLE);
                break;

            case R.id.collectCar:
                linner_order_view.setVisibility(View.GONE);
                linner_Secound.setVisibility(View.GONE);
                linner_Third.setVisibility(View.VISIBLE);
                linner_Fourth.setVisibility(View.GONE);
                break;

            case R.id.complete_additional:
                linner_order_view.setVisibility(View.GONE);
                linner_Secound.setVisibility(View.GONE);
                linner_Third.setVisibility(View.GONE);
                linner_Fourth.setVisibility(View.VISIBLE);
//
//                activity.replaceFragment(new ParkingConfirmation());

                break;
            case R.id.complete_Parking:
                linner_order_view.setVisibility(View.GONE);
                linner_Secound.setVisibility(View.GONE);
                linner_Third.setVisibility(View.GONE);
                linner_Fourth.setVisibility(View.GONE);
//
                activity.replaceFragment(new ParkingConfirmation());

                break;
        }
    }
}
