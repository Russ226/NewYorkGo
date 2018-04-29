package com.tareksaidee.newyorkgo.outdoorswimming;

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
import com.tareksaidee.newyorkgo.DTO.OutdoorSwimming;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;
import java.util.Random;

public class OutdoorSwimmingAdapter extends RecyclerView.Adapter<OutdoorSwimmingAdapter.OutdoorSwimmingPoolViewHolder> {

    ArrayList<OutdoorSwimming> ODS;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;

    OutdoorSwimmingAdapter(@NonNull Context context, ArrayList<OutdoorSwimming> ODS) {
        mContext = context;
        this.ODS = ODS;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public OutdoorSwimmingPoolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.outdoor_swimming, parent, false);
        return new OutdoorSwimmingPoolViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OutdoorSwimmingPoolViewHolder holder, int position) {
        final OutdoorSwimming O = ODS.get(position);
        holder.name.setText(O.getName());
        holder.phone.setText(O.getPhone());
        holder.poolsOutdoorType.setText(O.getPoolsOutdoorType());
        holder.setting.setText(O.getSetting());
        holder.size.setText(O.getSize());
        holder.lat.setText(O.getLat());
        holder.longitude.setText(O.getLongitude());
        holder.recCenterId.setText(O.getRecCenterId());

        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(O);
                    Bookmark bookmark = new Bookmark(O.getName(), key, "outdoorswimming");
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
                intent.putExtra("address", O.getLocation());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ODS.size();
    }

    void clear() {
        ODS.clear();
    }

    class OutdoorSwimmingPoolViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView phone;
        TextView poolsOutdoorType;
        TextView setting;
        TextView size;
        TextView lat;
        TextView longitude;
        TextView recCenterId;
        Button mapButton;
        Button bookmarkButton;

        OutdoorSwimmingPoolViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            phone = (TextView) view.findViewById(R.id.phone);
            poolsOutdoorType = (TextView) view.findViewById(R.id.poolOutdoorType);
            setting = (TextView) view.findViewById(R.id.setting);
            size = (TextView) view.findViewById(R.id.size);
            lat = (TextView) view.findViewById(R.id.lat);
            longitude = (TextView) view.findViewById(R.id.longitude);
            recCenterId = (TextView) view.findViewById(R.id.recCenterID);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);
        }
    }
}
