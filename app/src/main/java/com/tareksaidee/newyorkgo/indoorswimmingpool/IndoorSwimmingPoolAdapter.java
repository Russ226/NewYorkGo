package com.tareksaidee.newyorkgo.indoorswimmingpool;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.IndoorSwimmingPool;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.indoorswimmingpool.IndoorSwimmingPoolActivity;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class IndoorSwimmingPoolAdapter extends RecyclerView.Adapter<IndoorSwimmingPoolAdapter.IndoorSwimmingPoolViewHolder> {
    //private ArrayList<BBQ> bbqs;
    private ArrayList<IndoorSwimmingPool> ISP;
    //private RecyclerView bbqsView;
    private RecyclerView indoorSwimmingPoolView;
    //private BBQAdapter bbqAdapter;
    private IndoorSwimmingPoolAdapter ISPAdapter;
    private JsonParser parser;

    //ArrayList<BBQ> bbqs;
    private Context mContext;

    IndoorSwimmingPoolAdapter(@NonNull Context context, ArrayList<IndoorSwimmingPool> ISP) {
        mContext = context;
        this.ISP = ISP;
    }

    @Override
    public IndoorSwimmingPoolAdapter.IndoorSwimmingPoolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bbq_card, parent, false);
        return new IndoorSwimmingPoolViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IndoorSwimmingPoolAdapter.IndoorSwimmingPoolViewHolder holder, int position) {
        //BBQ bbq = bbqs.get(position);
        IndoorSwimmingPool IP = ISP.get(position);
        holder.name.setText(IP.getName());
        holder.location.setText(IP.getLocation());
        holder.phone.setText(IP.getPhone());
        holder.poolndoorType.setText(IP.getPoolsIndoorType());
        holder.setting.setText(IP.getSetting());
        holder.size.setText(IP.getSize());
        holder.accessible.setText(IP.getAccessible());
        holder.lat.setText(IP.getLat());
        holder.longitude.setText(IP.getLongitude());
        holder.recCenterID.setText(IP.getName());
    }

    @Override
    public int getItemCount() {
        return ISP.size();
    }

    void clear() {
        ISP.clear();
    }

    class IndoorSwimmingPoolViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView location;
        TextView phone;
        TextView poolndoorType;
        TextView setting;
        TextView size;
        TextView accessible;
        TextView lat;
        TextView longitude;
        TextView recCenterID;

        IndoorSwimmingPoolViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            phone = (TextView) view.findViewById(R.id.phone);
            poolndoorType = (TextView) view.findViewById(R.id.poolIndoorType);
            setting = (TextView) view.findViewById(R.id.setting);
            size = (TextView) view.findViewById(R.id.size);
            accessible = (TextView) view.findViewById(R.id.accessible);
            lat = (TextView) view.findViewById(R.id.lat);
            longitude = (TextView) view.findViewById(R.id.longitude);
            recCenterID = (TextView) view.findViewById(R.id.recCenterID);
        }
    }
}
