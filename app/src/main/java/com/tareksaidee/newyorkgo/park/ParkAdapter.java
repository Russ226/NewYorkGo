package com.tareksaidee.newyorkgo.park;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.Park;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;
import com.tareksaidee.newyorkgo.museum.MuseumAdapter;

import java.util.ArrayList;

public class ParkAdapter extends RecyclerView.Adapter<ParkAdapter.ParkViewHolder> implements View.OnClickListener {
    ArrayList<Park> parks;
    private Context mContext;

    ParkAdapter(@NonNull Context context, ArrayList<Park> parks) {
        mContext = context;
        this.parks = parks;
    }

    @Override
    public ParkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.park_card, parent, false);
        return new ParkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ParkViewHolder holder, int position) {
        Park p = parks.get(position);
        holder.name.setText(p.getName());
        holder.location.setText(p.getLocation());
        holder.zipCode.setText(p.getZipCode());
    }

    @Override
    public int getItemCount() {
        return parks.size();
    }

    void clear() { parks.clear(); }

    class ParkViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView location;
        TextView zipCode;

        ParkViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            zipCode = (TextView) view.findViewById(R.id.zip);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, ShowAddressActivity.class);
        intent.putExtra("address", ((TextView) view.findViewById(R.id.location)).getText().toString());
        mContext.startActivity(intent);
    }

}
