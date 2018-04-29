package com.tareksaidee.newyorkgo.museum;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.Beaches;
import com.tareksaidee.newyorkgo.DTO.Museum;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;
import com.tareksaidee.newyorkgo.beaches.BeachesAdapter;

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
        //fill out
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
        //fill out

        MuseumViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            //fill out
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, ShowAddressActivity.class);
        intent.putExtra("address", ((TextView) view.findViewById(R.id.location)).getText().toString());
        mContext.startActivity(intent);
    }

}
