package com.tareksaidee.newyorkgo.beaches;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.Beaches;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;

public class BeachesAdapter extends RecyclerView.Adapter<BeachesAdapter.BeachesViewHolder> implements View.OnClickListener{

    ArrayList<Beaches> beaches;
    private Context mContext;

    BeachesAdapter(@NonNull Context context, ArrayList<Beaches> beaches) {
        mContext = context;
        this.beaches = beaches;
    }

    @Override
    public BeachesAdapter.BeachesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.beach_card, parent, false);
        return new BeachesAdapter.BeachesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeachesAdapter.BeachesViewHolder holder, int position) {
        Beaches beach = beaches.get(position);
        //holder.location.setText(beach.getLocation());
        holder.name.setText(beach.getName());
        holder.phone.setText(beach.getPhone());
        holder.surf.setText(beach.getSurf());
        holder.note.setText(beach.getNote());
        holder.accessible.setText(beach.getAccessible());
        holder.accesibleNote.setText(beach.getAccessibleNotes());
        holder.barbecue.setText(beach.getBarbecueAllowed());
        holder.bathroom.setText(beach.getBathroom());
        holder.bikeSkate.setText(beach.getBicycleAndSkatePath());
        holder.boardWalk.setText(beach.getBoardwalk());
        holder.latitutde.setText(beach.getLat());
        holder.lon.setText(beach.getLon());
        holder.description.setText(beach.getDescription());
        holder.location.setText(beach.getLocation());
    }

    @Override
    public int getItemCount() {
        return beaches.size();
    }

    void clear() {
        beaches.clear();
    }

    class BeachesViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView location;
        TextView phone;
        TextView surf;
        TextView note;
        TextView accessible;
        TextView accesibleNote;
        TextView barbecue;
        TextView bathroom;
        TextView bikeSkate;
        TextView boardWalk;
        TextView latitutde;
        TextView longitude;
        TextView lon;
        TextView description;

        BeachesViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            phone = (TextView) view.findViewById(R.id.phone);
            surf = (TextView) view.findViewById(R.id.surf);
            note = (TextView) view.findViewById(R.id.note);
            accessible = (TextView) view.findViewById(R.id.accessible);
            accesibleNote = (TextView) view.findViewById(R.id.accessibleNotes);
            barbecue = (TextView) view.findViewById(R.id.bbqOK);
            bathroom = (TextView) view.findViewById(R.id.bathroom);
            bikeSkate = (TextView) view.findViewById(R.id.bikeAndSkate);
            boardWalk = (TextView) view.findViewById(R.id.boardwalk);
            longitude = (TextView) view.findViewById(R.id.lon);
            latitutde = (TextView) view.findViewById(R.id.lat);
            description = (TextView) view.findViewById(R.id.description);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, ShowAddressActivity.class);
        intent.putExtra("address", ((TextView) view.findViewById(R.id.location)).getText().toString());
        mContext.startActivity(intent);
    }
}
