package com.hexagon.parcodriver.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hexagon.parcodriver.BaseActivity;
import com.hexagon.parcodriver.R;
import com.hexagon.parcodriver.fragment.HistorydetailsFragment;


public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {


    private final BaseActivity activity;

    public HistoryAdapter(BaseActivity activity) {

        this.activity=activity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_history_completed, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.replaceFragment(new HistorydetailsFragment());
            }
        });
        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

//        viewHolder.txtViewTitle.setText(itemsData[position].getString());



    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;


        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            cardView = (CardView) itemLayoutView.findViewById(R.id.cardView);

        }
    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 10;
    }
}
