package com.tareksaidee.newyorkgo.naturepreserves;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.NaturePreserves;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;
import com.tareksaidee.newyorkgo.naturepreserves.NaturePreservesActivity;

import java.util.ArrayList;

public class NaturePreservesAdapter extends RecyclerView.Adapter<NaturePreservesAdapter.NaturePreservesViewHolder> implements View.OnClickListener {
    ArrayList<NaturePreserves> naturePreserves;
    private Context mContext;

    NaturePreservesAdapter(@NonNull Context context, ArrayList<NaturePreserves> naturePreserves) {
        mContext = context;
        this.naturePreserves = naturePreserves;
    }

    @Override
    public NaturePreservesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.nature_preserves_card, parent, false);
        view.setOnClickListener(this);
        return new NaturePreservesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NaturePreservesViewHolder holder, int position) {
        NaturePreserves NP = naturePreserves.get(position);
        holder.parkId.setText(NP.getParkId());
        holder.parkName.setText(NP.getParkName());
        holder.sanctuaryName.setText(NP.getSanctuaryName());
        holder.borough.setText(NP.getBorough());
        holder.acres.setText(NP.getAcres());
        holder.directions.setText(NP.getDirections());
        holder.description.setText(NP.getDescription());
        holder.habitatType.setText(NP.getHabitatType());
    }

    @Override
    public int getItemCount() {
        return naturePreserves.size();
    }

    void clear() {
        naturePreserves.clear();
    }

    class NaturePreservesViewHolder extends RecyclerView.ViewHolder {

        TextView parkId;
        TextView parkName;
        TextView sanctuaryName;
        TextView borough;
        TextView acres;
        TextView directions;
        TextView description;
        TextView habitatType;

        NaturePreservesViewHolder(View view) {
            super(view);
            parkId = (TextView) view.findViewById(R.id.parkID);
            parkName = (TextView) view.findViewById(R.id.parkName);
            sanctuaryName = (TextView) view.findViewById(R.id.san);
            borough = (TextView) view.findViewById(R.id.bor);
            acres = (TextView) view.findViewById(R.id.acre);
            directions = (TextView) view.findViewById(R.id.directions);
            description = (TextView) view.findViewById(R.id.description);
            habitatType = (TextView) view.findViewById(R.id.hab);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, ShowAddressActivity.class);
        intent.putExtra("address", ((TextView) view.findViewById(R.id.address)).getText().toString());
        mContext.startActivity(intent);
    }
}
