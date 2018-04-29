package com.tareksaidee.newyorkgo.indoorswimmingpool;

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
import com.tareksaidee.newyorkgo.DTO.IndoorSwimmingPool;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;
import java.util.Random;

public class IndoorSwimmingPoolAdapter extends RecyclerView.Adapter<IndoorSwimmingPoolAdapter.IndoorSwimmingPoolViewHolder> {

    private ArrayList<IndoorSwimmingPool> ISP;
    private RecyclerView indoorSwimmingPoolView;
    private IndoorSwimmingPoolAdapter ISPAdapter;
    private JsonParser parser;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;
    private Context mContext;

    IndoorSwimmingPoolAdapter(@NonNull Context context, ArrayList<IndoorSwimmingPool> ISP) {
        mContext = context;
        this.ISP = ISP;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public IndoorSwimmingPoolAdapter.IndoorSwimmingPoolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.indoor_swimming_pool_card, parent, false);
        return new IndoorSwimmingPoolViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IndoorSwimmingPoolAdapter.IndoorSwimmingPoolViewHolder holder, int position) {
        final IndoorSwimmingPool IP = ISP.get(position);
        holder.name.setText(IP.getName());
        holder.location.setText(IP.getLocation());
        holder.phone.setText(IP.getPhone());
        holder.poolndoorType.setText(IP.getPoolsIndoorType());
        holder.setting.setText(IP.getSetting());
        holder.size.setText(IP.getSize());
        holder.accessible.setText(IP.getAccessible());
        holder.lat.setText(IP.getLat());
        holder.longitude.setText(IP.getLongitude());
        holder.recCenterID.setText(IP.getName());

        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(IP);
                    Bookmark bookmark = new Bookmark(IP.getName(), key, "indoorswimmingpool");
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
                intent.putExtra("address", IP.getLocation());
                mContext.startActivity(intent);
            }
        });
        if(getItemCount()==1){
            holder.bookmarkButton.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return ISP.size();
    }

    void clear() {
        ISP.clear();
    }

    class IndoorSwimmingPoolViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView location;
        TextView phone;
        TextView poolndoorType;
        TextView setting;
        TextView size;
        TextView accessible;
        TextView lat;
        TextView longitude;
        TextView recCenterID;
        Button mapButton;
        Button bookmarkButton;

        IndoorSwimmingPoolViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            phone = (TextView) view.findViewById(R.id.phone);
            poolndoorType = (TextView) view.findViewById(R.id.poolIndoorType);
            setting = (TextView) view.findViewById(R.id.setting);
            size = (TextView) view.findViewById(R.id.size);
            accessible = (TextView) view.findViewById(R.id.accessible);
            lat = (TextView) view.findViewById(R.id.lat);
            longitude = (TextView) view.findViewById(R.id.longitude);
            recCenterID = (TextView) view.findViewById(R.id.recCenterID);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);
        }
    }
}
