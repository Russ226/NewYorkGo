package com.tareksaidee.newyorkgo.eateries;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.Eateries;
import com.tareksaidee.newyorkgo.R;

import java.util.ArrayList;

public class EateriesAdapter extends RecyclerView.Adapter<EateriesAdapter.EateriesViewHolder> {

    ArrayList<Eateries> e;
    private Context mContext;

    EateriesAdapter(@NonNull Context context, ArrayList<Eateries> e) {
        mContext = context;
        this.e = e;

    }

    @Override
    public EateriesAdapter.EateriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.eateries_card, parent, false);
        return new EateriesAdapter.EateriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EateriesAdapter.EateriesViewHolder holder, int position) {
        Eateries eatery = e.get(position);
        holder.location.setText(eatery.getLocation());
        holder.name.setText(eatery.getName());
    }

    @Override
    public int getItemCount() {
        return e.size();
    }

    void clear() {
        e.clear();
    }

    class EateriesViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView location;
        TextView parkID;
        TextView startDate;
        TextView endDate;
        TextView description;
        TextView permitNumber;
        TextView phone;
        TextView website;
        TextView typeName;

        EateriesViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            parkID = (TextView) view.findViewById(R.id.location);
            startDate = (TextView) view.findViewById(R.id.startDate);
            endDate = (TextView) view.findViewById(R.id.endDate);
            description = (TextView) view.findViewById(R.id.description);
            permitNumber = (TextView) view.findViewById(R.id.permitNum);
            phone = (TextView) view.findViewById(R.id.phone);
            website = (TextView) view.findViewById(R.id.website);
            typeName = (TextView) view.findViewById(R.id.typeName);
        }
    }
}