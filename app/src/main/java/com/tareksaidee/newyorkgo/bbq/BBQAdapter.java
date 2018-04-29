
package com.tareksaidee.newyorkgo.bbq;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.BBQ;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;
import com.tareksaidee.newyorkgo.sorter.GPSTracker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by tarek on 4/28/2018.
 */

public class BBQAdapter extends RecyclerView.Adapter<BBQAdapter.BBQViewHolder> implements View.OnClickListener{

    ArrayList<BBQ> bbqs;
    private Context mContext;


    BBQAdapter(@NonNull Context context, ArrayList<BBQ> bbqs) throws IOException {
        mContext = context;
        this.bbqs = bbqs;
        GPSTracker userTracker = new GPSTracker(mContext);
        // System.out.println(userTracker.getGeocoderAddress(mContext));
        Location userLocation = new Location(userTracker.getLocations());
        for(BBQ bbq: bbqs){
            float[] results = new float[4];
            Geocoder geocoder = new Geocoder(mContext, new Locale("New York City"));
            List<Address> addresses = new ArrayList(geocoder.getFromLocationName(bbq.getName(), 1));
            if(addresses !=  null && addresses.size() > 0){
                userLocation.distanceBetween(userLocation.getLatitude(), userLocation.getLongitude(),addresses.get(0).getLatitude(),addresses.get(0).getLongitude(), results);
                bbq.setDistance(results[0]);
            }else{
                bbq.setDistance(9999999);
            }

        }

        Collections.sort(bbqs,BBQ.COMPARE_BY_DISTANCE);



    }

    @Override
    public BBQAdapter.BBQViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bbq_card, parent, false);
        return new BBQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BBQAdapter.BBQViewHolder holder, int position) {
        BBQ bbq = bbqs.get(position);
        holder.location.setText(bbq.getLocation());
        holder.name.setText(bbq.getName());
    }

    @Override
    public int getItemCount() {
        return bbqs.size();
    }

    void clear() {
        bbqs.clear();
    }

    class BBQViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView location;

        BBQViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, ShowAddressActivity.class);
        intent.putExtra("address", ((TextView) view.findViewById(R.id.location)).getText().toString());
        mContext.startActivity(intent);
    }


}
