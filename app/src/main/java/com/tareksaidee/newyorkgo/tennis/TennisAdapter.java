package com.tareksaidee.newyorkgo.tennis;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.tennis.TennisActivity;
import com.tareksaidee.newyorkgo.DTO.Tennis;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;


import java.util.ArrayList;

public class TennisAdapter extends RecyclerView.Adapter<TennisAdapter.TennisViewHolder> implements View.OnClickListener {
    ArrayList<Tennis> teenies;
    private Context mContext;

    TennisAdapter(@NonNull Context context, ArrayList<Tennis> teenies) {
        mContext = context;
        this.teenies = teenies;
    }

    @Override
    public TennisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tennis_card, parent, false);
        return new TennisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TennisViewHolder holder, int position) {
        Tennis t = teenies.get(position);
        holder.name.setText(t.getName());
        holder.location.setText(t.getLocation());
        holder.phone.setText(t.getPhone());
        holder.courts.setText(t.getCourts());
        holder.indoorOutdoor.setText(t.getIndoorOutdoor());
        holder.teenisType.setText(t.getTennisType());
        holder.accessible.setText(t.getAccessible());
        holder.info.setText(t.getInfo());
        holder.lat.setText(t.getLat());
        holder.lon.setText(t.getLon());
    }

    @Override
    public int getItemCount() {
        return teenies.size();
    }

    void clear() {
        teenies.clear();
    }

    class TennisViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView location;
        TextView phone;
        TextView courts;
        TextView indoorOutdoor;
        TextView teenisType;
        TextView accessible;
        TextView info;
        TextView lat;
        TextView lon;

        TennisViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            phone = (TextView) view.findViewById(R.id.phone);
            courts = (TextView) view.findViewById(R.id.court);
            indoorOutdoor = (TextView) view.findViewById(R.id.io);
            teenisType = (TextView) view.findViewById(R.id.ttype);
            accessible = (TextView) view.findViewById(R.id.accessible);
            info = (TextView) view.findViewById(R.id.inf);
            lat = (TextView) view.findViewById(R.id.lat);
            lon = (TextView) view.findViewById(R.id.longitude);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, ShowAddressActivity.class);
        intent.putExtra("address", ((TextView) view.findViewById(R.id.location)).getText().toString());
        mContext.startActivity(intent);
    }
}
