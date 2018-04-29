package com.tareksaidee.newyorkgo.hiking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.Hiking;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.hiking.HikingAdapter;


import java.util.ArrayList;

public class HikingAdapter extends RecyclerView.Adapter<HikingAdapter.HikingViewHolder> {

    ArrayList<Hiking> h;
    private Context mContext;

    HikingAdapter(@NonNull Context context, ArrayList<Hiking> h) {
        mContext = context;
        this.h = h;
    }

    @Override
    public HikingAdapter.HikingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.basketball_court_card, parent, false);
        return new HikingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HikingViewHolder holder, int position) {
        Hiking hiking = h.get(position);
        holder.name.setText(hiking.getName());
        holder.location.setText(hiking.getLocation());
        holder.parkName.setText(hiking.getParkName());
        holder.length.setText(hiking.getLength());
        holder.difficulty.setText(hiking.getDifficulty());
        holder.otherDetails.setText(hiking.getOtherDetails());
        holder.accessible.setText(hiking.getAccessible());
        holder.limitedAccess.setText(hiking.getLimitedAccess());
        holder.lat.setText(hiking.getLat());
        holder.lon.setText(hiking.getLon());
    }

    @Override
    public int getItemCount() {
        return h.size();
    }

    void clear() {
        h.clear();
    }

    class HikingViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView location;
        TextView parkName;
        TextView length;
        TextView difficulty;
        TextView otherDetails;
        TextView accessible;
        TextView limitedAccess;
        TextView lat;
        TextView lon;

        HikingViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            parkName = (TextView) view.findViewById(R.id.courts);
            length = (TextView) view.findViewById(R.id.length);
            difficulty = (TextView) view.findViewById(R.id.difficulty);
            otherDetails = (TextView) view.findViewById(R.id.otherDetails);
            accessible = (TextView) view.findViewById(R.id.accessible);
            limitedAccess = (TextView) view.findViewById(R.id.limitedAccess);
            lat = (TextView) view.findViewById(R.id.lat);
            lon = (TextView) view.findViewById(R.id.longitude);
        }
    }
}

