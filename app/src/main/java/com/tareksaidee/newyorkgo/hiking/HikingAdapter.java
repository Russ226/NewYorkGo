package com.tareksaidee.newyorkgo.hiking;

import android.content.Context;
import android.content.Intent;
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
import com.tareksaidee.newyorkgo.DTO.Bookmark;
import com.tareksaidee.newyorkgo.DTO.Hiking;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;
import java.util.Random;

public class HikingAdapter extends RecyclerView.Adapter<HikingAdapter.HikingViewHolder> {

    ArrayList<Hiking> h;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;

    HikingAdapter(@NonNull Context context, ArrayList<Hiking> h) {
        mContext = context;
        this.h = h;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public HikingAdapter.HikingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.hiking_card, parent, false);
        return new HikingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HikingViewHolder holder, int position) {
        final Hiking hiking = h.get(position);
        holder.name.setText(hiking.getName());
        holder.location.setText(hiking.getLocation());
        holder.parkName.setText(hiking.getParkName());
        holder.length.setText(hiking.getLength());
        holder.difficulty.setText(hiking.getDifficulty());
        holder.otherDetails.setText(hiking.getOtherDetails());
        holder.accessible.setText(hiking.getAccessible());
        holder.limitedAccess.setText(hiking.getLimitedAccess());
        holder.lat.setText(hiking.getLat());
        holder.lon.setText(hiking.getLon());

        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(h);
                    Bookmark bookmark = new Bookmark(hiking.getName(), key, "hiking","350 5th Ave");
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
                intent.putExtra("address", hiking.getLocation());
                mContext.startActivity(intent);
            }
        });
        if(getItemCount()==1){
            holder.bookmarkButton.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return h.size();
    }

    void clear() {
        h.clear();
    }

    class HikingViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView location;
        TextView parkName;
        TextView length;
        TextView difficulty;
        TextView otherDetails;
        TextView accessible;
        TextView limitedAccess;
        TextView lat;
        TextView lon;
        Button mapButton;
        Button bookmarkButton;

        HikingViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            parkName = (TextView) view.findViewById(R.id.parkName);
            length = (TextView) view.findViewById(R.id.length);
            difficulty = (TextView) view.findViewById(R.id.difficulty);
            otherDetails = (TextView) view.findViewById(R.id.otherDetails);
            accessible = (TextView) view.findViewById(R.id.accessible);
            limitedAccess = (TextView) view.findViewById(R.id.limitedAccess);
            lat = (TextView) view.findViewById(R.id.lat);
            lon = (TextView) view.findViewById(R.id.longitude);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);
        }
    }
}

