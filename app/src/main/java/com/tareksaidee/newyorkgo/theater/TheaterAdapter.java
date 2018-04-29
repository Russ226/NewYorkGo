package com.tareksaidee.newyorkgo.theater;

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
import com.tareksaidee.newyorkgo.DTO.Theater;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;
import java.util.Random;

public class TheaterAdapter extends RecyclerView.Adapter<TheaterAdapter.TheaterViewHolder> {
    ArrayList<Theater> theaters;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;

    TheaterAdapter(@NonNull Context context, ArrayList<Theater> theaters) {
        mContext = context;
        this.theaters = theaters;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public TheaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.theater_card, parent, false);
        return new TheaterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TheaterViewHolder holder, int position) {
        final Theater t = theaters.get(position);
        holder.name.setText(t.getName());
        holder.tel.setText(t.getTel());
        holder.url.setText(t.getUrl());
        holder.address1.setText(t.getAddress1());
        holder.address2.setText(t.getAddress2());
        holder.city.setText(t.getCity());
        holder.zipCode.setText(t.getZipCode());
        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(t);
                    Bookmark bookmark = new Bookmark(t.getName(), key, "theater");
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
                intent.putExtra("address", t.getAddress1());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return theaters.size();
    }

    void clear() {
        theaters.clear();
    }

    class TheaterViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView tel;
        TextView url;
        TextView address1;
        TextView address2;
        TextView city;
        TextView zipCode;
        Button mapButton;
        Button bookmarkButton;

        TheaterViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            tel = (TextView) view.findViewById(R.id.phone);
            url = (TextView) view.findViewById(R.id.url);
            address1 = (TextView) view.findViewById(R.id.address);
            address2 = (TextView) view.findViewById(R.id.address2);
            city = (TextView) view.findViewById(R.id.city);
            zipCode = (TextView) view.findViewById(R.id.zip);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);
        }
    }
}