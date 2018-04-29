package com.tareksaidee.newyorkgo.bball;

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
import com.tareksaidee.newyorkgo.DTO.BasketballCourt;
import com.tareksaidee.newyorkgo.DTO.Bookmark;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tarek on 4/28/2018.
 */

public class BasketballCourtAdapter extends RecyclerView.Adapter<BasketballCourtAdapter.BasketballCourtViewHolder>{

    ArrayList<BasketballCourt> bball;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;

    BasketballCourtAdapter(@NonNull Context context, ArrayList<BasketballCourt> bball) {
        mContext = context;
        this.bball = bball;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();

    }

    @Override
    public BasketballCourtAdapter.BasketballCourtViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.basketball_court_card, parent, false);
        return new BasketballCourtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BasketballCourtAdapter.BasketballCourtViewHolder holder, int position) {
        final BasketballCourt bballs = bball.get(position);

        holder.name.setText(bballs.getName());
        holder.address.setText(bballs.getLocation());
        holder.numCourts.setText(bballs.getName());
        holder.wheelchairAccess.setText(bballs.getWheelchair());

        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(bballs);
                    Bookmark bookmark = new Bookmark(bballs.getName(), key);
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
                intent.putExtra("address", bballs.getLocation());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bball.size();
    }

    void clear() {
        bball.clear();
    }

    class BasketballCourtViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView address;
        TextView numCourts;
        TextView wheelchairAccess;
        Button mapButton;
        Button bookmarkButton;


        BasketballCourtViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            address = (TextView) view.findViewById(R.id.location);
            numCourts = (TextView) view.findViewById(R.id.courts);
            wheelchairAccess = (TextView) view.findViewById(R.id.accessible);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);

        }
    }
}
