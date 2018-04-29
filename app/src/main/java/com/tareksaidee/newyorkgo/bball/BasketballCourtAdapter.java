package com.tareksaidee.newyorkgo.bball;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.BasketballCourt;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;

/**
 * Created by tarek on 4/28/2018.
 */

public class BasketballCourtAdapter extends RecyclerView.Adapter<BasketballCourtAdapter.BasketballCourtViewHolder> implements View.OnClickListener{

    ArrayList<BasketballCourt> bball;
    private Context mContext;

    BasketballCourtAdapter(@NonNull Context context, ArrayList<BasketballCourt> bball) {
        mContext = context;
        this.bball = bball;

    }

    @Override
    public BasketballCourtAdapter.BasketballCourtViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.basketball_court_card, parent, false);
        return new BasketballCourtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BasketballCourtAdapter.BasketballCourtViewHolder holder, int position) {
        BasketballCourt bballs = bball.get(position);

        holder.name.setText(bballs.getName());
        holder.address.setText(bballs.getLocation());
        holder.numCourts.setText(bballs.getName());
        holder.wheelchairAccess.setText(bballs.getWheelchair());
    }

    @Override
    public int getItemCount() {
        return bball.size();
    }

    void clear() {
        bball.clear();
    }

    class BasketballCourtViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView address;
        TextView numCourts;
        TextView wheelchairAccess;


        BasketballCourtViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            address = (TextView) view.findViewById(R.id.location);
            numCourts = (TextView) view.findViewById(R.id.courts);
            wheelchairAccess = (TextView) view.findViewById(R.id.accessible);

        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, ShowAddressActivity.class);
        intent.putExtra("address", ((TextView) view.findViewById(R.id.location)).getText().toString());
        mContext.startActivity(intent);
    }
}
