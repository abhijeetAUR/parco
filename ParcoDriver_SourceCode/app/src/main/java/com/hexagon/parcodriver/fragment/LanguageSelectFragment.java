package com.hexagon.parcodriver.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.hexagon.parcodriver.BaseFragment;
import com.hexagon.parcodriver.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LanguageSelectFragment extends BaseFragment implements View.OnClickListener {

    private Button englishBtn;
    private Button arabicBtn;

    public LanguageSelectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setToolbar();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_language_select, container, false);
    }

    private void setToolbar() {
        toolbar.setVisibility(View.GONE);
        try {

            lockDrawer(true);


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setListner();

    }

    private void setListner() {
        englishBtn.setOnClickListener(this);
        arabicBtn.setOnClickListener(this);
    }

    private void initView(View view) {
        englishBtn=(Button)view.findViewById(R.id.englishBtn);
        arabicBtn=(Button)view.findViewById(R.id.arabicBtn);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.englishBtn:

                activity.replaceFragment(new LoginFragment());


                break;

            case R.id.arabicBtn:
                Toast.makeText(activity,"Under Development", Toast.LENGTH_SHORT).show();

                break;
        }

    }
}
