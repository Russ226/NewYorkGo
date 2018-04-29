package com.tareksaidee.newyorkgo.tennis;

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
import com.tareksaidee.newyorkgo.DTO.Tennis;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;
import java.util.Random;

public class TennisAdapter extends RecyclerView.Adapter<TennisAdapter.TennisViewHolder> {
    ArrayList<Tennis> teenies;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;

    TennisAdapter(@NonNull Context context, ArrayList<Tennis> teenies) {
        mContext = context;
        this.teenies = teenies;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public TennisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tennis_card, parent, false);
        return new TennisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TennisViewHolder holder, int position) {
        final Tennis t = teenies.get(position);
        holder.name.setText(t.getName());
        holder.location.setText(t.getLocation());
        holder.phone.setText(t.getPhone());
        holder.courts.setText(t.getCourts());
        holder.indoorOutdoor.setText(t.getIndoorOutdoor());
        holder.teenisType.setText(t.getTennisType());
        holder.accessible.setText(t.getAccessible());
        holder.info.setText(t.getInfo());
        holder.lat.setText(t.getLat());
        holder.lon.setText(t.getLon());
        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(t);
                    Bookmark bookmark = new Bookmark(t.getName(), key, "tennis");
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
                intent.putExtra("address", t.getLocation());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return teenies.size();
    }

    void clear() {
        teenies.clear();
    }

    class TennisViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView location;
        TextView phone;
        TextView courts;
        TextView indoorOutdoor;
        TextView teenisType;
        TextView accessible;
        TextView info;
        TextView lat;
        TextView lon;
        Button mapButton;
        Button bookmarkButton;

        TennisViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            phone = (TextView) view.findViewById(R.id.phone);
            courts = (TextView) view.findViewById(R.id.court);
            indoorOutdoor = (TextView) view.findViewById(R.id.io);
            teenisType = (TextView) view.findViewById(R.id.ttype);
            accessible = (TextView) view.findViewById(R.id.accessible);
            info = (TextView) view.findViewById(R.id.inf);
            lat = (TextView) view.findViewById(R.id.lat);
            lon = (TextView) view.findViewById(R.id.longitude);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);
        }
    }

}
