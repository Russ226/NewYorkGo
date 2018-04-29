package com.tareksaidee.newyorkgo.theater;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.Theater;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;

public class TheaterAdapter extends RecyclerView.Adapter<TheaterAdapter.TheaterViewHolder> implements View.OnClickListener {
    ArrayList<Theater> theaters;
    private Context mContext;

    TheaterAdapter(@NonNull Context context, ArrayList<Theater> theaters) {
        mContext = context;
        this.theaters = theaters;
    }

    @Override
    public TheaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.theater_card, parent, false);
        return new TheaterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TheaterViewHolder holder, int position) {
        Theater t = theaters.get(position);
        holder.name.setText(t.getName());
        holder.tel.setText(t.getTel());
        holder.url.setText(t.getUrl());
        holder.address1.setText(t.getAddress1());
        holder.address2.setText(t.getAddress2());
        holder.city.setText(t.getCity());
        holder.zipCode.setText(t.getZipCode());
    }

    @Override
    public int getItemCount() {
        return theaters.size();
    }

    void clear() {
        theaters.clear();
    }

    class TheaterViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView tel;
        TextView url;
        TextView address1;
        TextView address2;
        TextView city;
        TextView zipCode;

        TheaterViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            tel = (TextView) view.findViewById(R.id.phone);
            url = (TextView) view.findViewById(R.id.url);
            address1 = (TextView) view.findViewById(R.id.address);
            address2 = (TextView) view.findViewById(R.id.address2);
            city = (TextView) view.findViewById(R.id.city);
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