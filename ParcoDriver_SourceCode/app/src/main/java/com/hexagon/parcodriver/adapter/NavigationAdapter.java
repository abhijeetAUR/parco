package com.hexagon.parcodriver.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.hexagon.parcodriver.MainActivity;
import com.hexagon.parcodriver.R;
import com.hexagon.parcodriver.model.NevigationItem;

import java.util.ArrayList;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.MyViewHolder> {

    private final MainActivity context;
    private ArrayList<NevigationItem> nevigationItemList;
    private NavigationClickListner navigationClickListner;

    public NavigationAdapter(MainActivity context, NavigationClickListner navigationClickListner) {
       this.context=context;
        nevigationItemList = new ArrayList<>();
        this.navigationClickListner = navigationClickListner;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.navigation_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        final NevigationItem nevigationItem = nevigationItemList.get(position);

        holder.icon.setBackground(nevigationItem.drawable);
        holder.iconName.setText(nevigationItem.menuname);
        holder.navigiationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationClickListner.itemOnClickListner(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return nevigationItemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView icon;
        private final TextView iconName;
        private final LinearLayout navigiationBtn;

        public MyViewHolder(View view) {
            super(view);
            icon = (ImageView) view.findViewById(R.id.iconimg);
            iconName = (TextView) view.findViewById(R.id.iconName);
            navigiationBtn = (LinearLayout) view.findViewById(R.id.navigiationBtn);
        }
    }

    public void addItem(NevigationItem nevigationItem) {
        nevigationItemList.add(nevigationItem);
        notifyDataSetChanged();
    }

    public interface NavigationClickListner {
        void itemOnClickListner(int position);
    }
}