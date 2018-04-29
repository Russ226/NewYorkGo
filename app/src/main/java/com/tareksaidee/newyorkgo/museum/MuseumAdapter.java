package com.tareksaidee.newyorkgo.museum;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.Museum;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;

public class MuseumAdapter extends RecyclerView.Adapter<MuseumAdapter.MuseumViewHolder> implements View.OnClickListener {
    //ArrayList<Beaches> beaches;
    ArrayList<Museum> museums;
    private Context mContext;

    MuseumAdapter(@NonNull Context context, ArrayList<Museum> museums) {
        mContext = context;
        this.museums = museums;
    }

    @Override
    public MuseumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.museum_card, parent, false);
        return new MuseumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MuseumViewHolder holder, int position) {
        Museum m = museums.get(position);
        holder.name.setText(m.getName());
        holder.tel.setText(m.getName());
        holder.url.setText(m.getName());
        holder.address1.setText(m.getName());
        holder.address2.setText(m.getName());
        holder.city.setText(m.getName());
        holder.zipCode.setText(m.getName());
    }

    @Override
    public int getItemCount() {
        return museums.size();
    }

    void clear() {
        museums.clear();
    }

    class MuseumViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView tel;
        TextView url;
        TextView address1;
        TextView address2;
        TextView city;
        TextView zipCode;

        MuseumViewHolder(View view) {
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
