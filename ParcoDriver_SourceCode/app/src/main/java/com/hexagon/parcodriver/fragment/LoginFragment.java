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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hexagon.parcodriver.BaseFragment;
import com.hexagon.parcodriver.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener{


    private EditText email;
    private EditText password;
    private Button loginBtn;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setToolbar();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setListner();
    }


    private void setListner() {
        loginBtn.setOnClickListener(this);


    }

    private void initView(View view) {
        email=(EditText)view.findViewById(R.id.email);
        password=(EditText)view.findViewById(R.id.password);
        loginBtn=(Button)view.findViewById(R.id.loginBtn);




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
    public void onClick(View v) {


        switch (v.getId()){



            case R.id.loginBtn:

                activity.removeFragments(getFragmentManager().getBackStackEntryCount());
                activity.replaceFragment(new HomeFragment(),false,true,false);
                break;


        }

    }
}
