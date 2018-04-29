package com.tareksaidee.newyorkgo.museum;

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
import com.tareksaidee.newyorkgo.DTO.Museum;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;
import java.util.Random;

public class MuseumAdapter extends RecyclerView.Adapter<MuseumAdapter.MuseumViewHolder> {
    ArrayList<Museum> museums;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;

    MuseumAdapter(@NonNull Context context, ArrayList<Museum> museums) {
        mContext = context;
        this.museums = museums;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public MuseumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.museum_card, parent, false);
        return new MuseumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MuseumViewHolder holder, int position) {
        final Museum m = museums.get(position);
        holder.name.setText(m.getName());
        holder.tel.setText(m.getName());
        holder.url.setText(m.getName());
        holder.address1.setText(m.getName());
        holder.address2.setText(m.getName());
        holder.city.setText(m.getName());
        holder.zipCode.setText(m.getName());

        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(m);
                    Bookmark bookmark = new Bookmark(m.getName(), key, "museum","350 5th Ave");
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
                intent.putExtra("address", m.getLocation());
                mContext.startActivity(intent);
            }
        });
        if(getItemCount()==1){
            holder.bookmarkButton.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return museums.size();
    }

    void clear() {
        museums.clear();
    }

    class MuseumViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView tel;
        TextView url;
        TextView address1;
        TextView address2;
        TextView city;
        TextView zipCode;
        Button mapButton;
        Button bookmarkButton;


        MuseumViewHolder(View view) {
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
