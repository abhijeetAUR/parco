package com.hexagon.parcodriver.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.hexagon.parcodriver.BaseFragment;
import com.hexagon.parcodriver.R;
import com.hexagon.parcodriver.adapter.AdditionalServicesAdapter;
import com.hexagon.parcodriver.adapter.HistoryAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistorydetailsFragment extends BaseFragment {


    private RecyclerView additionl_recy;

    public HistorydetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setToolbar();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historydetails, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    private void initView(View view) {
        additionl_recy=(RecyclerView)view.findViewById(R.id.additionl_recy);

        // 2. set layoutManger
        additionl_recy.setLayoutManager(new LinearLayoutManager(getActivity()));

        // this is data fro recycler view


        // 3. create an adapter
        AdditionalServicesAdapter mAdapter = new AdditionalServicesAdapter();
        // 4. set adapter
        additionl_recy.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        additionl_recy.setItemAnimator(new DefaultItemAnimator());
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
                i_image.setVisibility(View.VISIBLE);
                toolbarTitle.setText("History Details");
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
