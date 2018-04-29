
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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tareksaidee.newyorkgo.DTO.BBQ;
import com.tareksaidee.newyorkgo.DTO.Bookmark;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;
import com.tareksaidee.newyorkgo.sorter.GPSTracker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Created by tarek on 4/28/2018.
 */

public class BBQAdapter extends RecyclerView.Adapter<BBQAdapter.BBQViewHolder> {

    ArrayList<BBQ> bbqs;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;


    BBQAdapter(@NonNull Context context, ArrayList<BBQ> bbqs) throws IOException {
        mContext = context;
        this.bbqs = bbqs;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
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
        final BBQ bbq = bbqs.get(position);
        holder.location.setText(bbq.getLocation());
        holder.name.setText(bbq.getName());
        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(bbq);
                    Bookmark bookmark = new Bookmark(bbq.getName(), key, "bbq","350 5th Ave");
                    mBookmarksDatabaseReferencePart.child(mFirebaseAuth.getCurrentUser().getUid() + "/part/")
                            .push().setValue(bookmark);
                    Toast.makeText(mContext, "Bookmarked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "Not logged in", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ShowAddressActivity.class);
                intent.putExtra("address", bbq.getLocation());
                mContext.startActivity(intent);
            }
        });
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
        Button mapButton;
        Button bookmarkButton;

        BBQViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);
        }
    }


}
