package com.tareksaidee.newyorkgo.dogruns;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.DogRuns;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;

public class DogRunsAdapter extends RecyclerView.Adapter<DogRunsAdapter.DogRunsViewHolder> implements View.OnClickListener{
    ArrayList<DogRuns> dogRuns;
    private Context mContext;

    DogRunsAdapter(@NonNull Context context, ArrayList<DogRuns> dogRuns) {
        mContext = context;
        this.dogRuns = dogRuns;
    }

    @Override
    public DogRunsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dog_runs_card, parent, false);
        return new DogRunsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DogRunsViewHolder holder, int position) {
        DogRuns d = dogRuns.get(position);
        holder.name.setText(d.getName());
        holder.address.setText(d.getName());
        holder.dogRunsType.setText(d.getName());
        holder.accessible.setText(d.getName());
        holder.notes.setText(d.getName());
    }

    @Override
    public int getItemCount() {
        return dogRuns.size();
    }

    void clear() { dogRuns.clear(); }

    class DogRunsViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView address;
        TextView dogRunsType;
        TextView accessible;
        TextView notes;

        DogRunsViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            address = (TextView) view.findViewById(R.id.address);
            dogRunsType = (TextView) view.findViewById(R.id.dogRunType);
            accessible = (TextView) view.findViewById(R.id.accessible);
            notes = (TextView) view.findViewById(R.id.notes);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, ShowAddressActivity.class);
        intent.putExtra("address", ((TextView) view.findViewById(R.id.location)).getText().toString());
        mContext.startActivity(intent);
    }
}

