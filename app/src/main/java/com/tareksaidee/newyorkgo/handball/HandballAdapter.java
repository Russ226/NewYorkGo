package com.tareksaidee.newyorkgo.handball;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.BBQ;
import com.tareksaidee.newyorkgo.DTO.Handball;
import com.tareksaidee.newyorkgo.bbq.BBQAdapter;
import com.tareksaidee.newyorkgo.handball.HandballActivity;

import java.util.ArrayList;

public class HandballAdapter extends RecyclerView.Adapter<HandballAdapter.HandballViewHolder>{

    //ArrayList<BBQ> bbqs;
    ArrayList<Handball> H;
    private Context mContext;

    HandballAdapter(@NonNull Context context, ArrayList<Handball> H) {
        mContext = context;
        this.H = H;

    }

    @Override
    public HandballViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bbq_card, parent, false);
        return new HandballViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HandballViewHolder holder, int position) {
        //BBQ bbq = H.get(position);
        Handball h = H.get(position);
        holder.location.setText((h.getLocation()));
        holder.numCourts.setText(h.getNumOfCourts());
        holder.name.setText(h.getName());
    }

    @Override
    public int getItemCount() {
        return H.size();
    }

    void clear() {
        H.clear();
    }

    class HandballViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView location;
        TextView numCourts;

        HandballViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            numCourts = (TextView) view.findViewById(R.id.numCourts);
        }
    }
}