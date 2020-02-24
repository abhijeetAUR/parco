package com.hexagon.parcodriver.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hexagon.parcodriver.BaseFragment;
import com.hexagon.parcodriver.R;
import com.hexagon.parcodriver.adapter.NotificationAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends BaseFragment implements View.OnClickListener {


    private CardView general_card;
    private CardView custom_card;
    private TextView general_txt;
    private TextView custom_txt;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setToolbar();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        setListner();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recy);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // this is data fro recycler view

        // 3. create an adapter
        NotificationAdapter mAdapter = new NotificationAdapter();
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setListner() {
        general_card.setOnClickListener(this);
        custom_card.setOnClickListener(this);
        general_txt.setOnClickListener(this);
        custom_txt.setOnClickListener(this);
    }

    private void initView(View view) {
        general_card=(CardView)view.findViewById(R.id.general_card);
        custom_card=(CardView)view.findViewById(R.id.custom_card);
        general_txt=(TextView)view.findViewById(R.id.general_txt);
        custom_txt=(TextView)view.findViewById(R.id.custom_txt);
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

                backBtn.setVisibility(View.VISIBLE);
                toolbarTitle.setVisibility(View.VISIBLE);
                toolbarTitle.setText("Notifications");
                i_image.setVisibility(View.VISIBLE);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.custom_card:
            case R.id.custom_txt:
                custom_card.setCardBackgroundColor(getResources().getColor(R.color.black));
                general_card.setCardBackgroundColor(getResources().getColor(R.color.white));
                general_txt.setTextColor(getResources().getColor(R.color.black));
                custom_txt.setTextColor(getResources().getColor(R.color.white));
                break;

            case R.id.general_card:
            case R.id.general_txt:
                custom_card.setCardBackgroundColor(getResources().getColor(R.color.white));
                general_card.setCardBackgroundColor(getResources().getColor(R.color.black));
                general_txt.setTextColor(getResources().getColor(R.color.white));
                custom_txt.setTextColor(getResources().getColor(R.color.black));
                break;
        }
    }
}
