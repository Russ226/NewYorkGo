package com.tareksaidee.newyorkgo.handball;

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
import com.tareksaidee.newyorkgo.DTO.BBQ;
import com.tareksaidee.newyorkgo.DTO.Bookmark;
import com.tareksaidee.newyorkgo.DTO.Handball;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;
import com.tareksaidee.newyorkgo.bbq.BBQAdapter;
import com.tareksaidee.newyorkgo.handball.HandballActivity;

import java.util.ArrayList;
import java.util.Random;

public class HandballAdapter extends RecyclerView.Adapter<HandballAdapter.HandballViewHolder> {

    ArrayList<Handball> H;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;

    HandballAdapter(@NonNull Context context, ArrayList<Handball> H) {
        mContext = context;
        this.H = H;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public HandballViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.handball_card, parent, false);
        return new HandballViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HandballViewHolder holder, int position) {
        //BBQ bbq = H.get(position);
        final Handball h = H.get(position);
        holder.location.setText((h.getLocation()));
        holder.numCourts.setText(h.getNumOfCourts());
        holder.name.setText(h.getName());

        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(h);
                    Bookmark bookmark = new Bookmark(h.getName(), key, "handball");
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
                intent.putExtra("address", h.getLocation());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return H.size();
    }

    void clear() {
        H.clear();
    }

    class HandballViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView location;
        TextView numCourts;
        Button mapButton;
        Button bookmarkButton;

        HandballViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            numCourts = (TextView) view.findViewById(R.id.courts);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);
        }
    }
}