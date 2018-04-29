package com.tareksaidee.newyorkgo.eateries;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.tareksaidee.newyorkgo.DTO.Eateries;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;
import java.util.Random;

public class EateriesAdapter extends RecyclerView.Adapter<EateriesAdapter.EateriesViewHolder> {

    ArrayList<Eateries> e;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;

    EateriesAdapter(@NonNull Context context, ArrayList<Eateries> e) {
        mContext = context;
        this.e = e;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public EateriesAdapter.EateriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.eateries_card, parent, false);
        return new EateriesAdapter.EateriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EateriesAdapter.EateriesViewHolder holder, int position) {
        final Eateries eatery = e.get(position);
        holder.location.setText(eatery.getLocation());
        holder.name.setText(eatery.getName());

        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(eatery);
                    Bookmark bookmark = new Bookmark(eatery.getName(), key, "eateries","350 5th Ave");
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
                intent.putExtra("address", eatery.getLocation());
                mContext.startActivity(intent);
            }
        });
        if(getItemCount()==1){
            Log.e("asdsadsad", getItemCount()+"");
            holder.bookmarkButton.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return e.size();
    }

    void clear() {
        e.clear();
    }

    class EateriesViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView location;
        TextView parkID;
        TextView startDate;
        TextView endDate;
        TextView description;
        TextView permitNumber;
        TextView phone;
        TextView website;
        TextView typeName;
        Button mapButton;
        Button bookmarkButton;

        EateriesViewHolder(View view) {
            super(view);
            parkID = (TextView) view.findViewById(R.id.parkID);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            startDate = (TextView) view.findViewById(R.id.startDate);
            endDate = (TextView) view.findViewById(R.id.endDate);
            description = (TextView) view.findViewById(R.id.description);
            permitNumber = (TextView) view.findViewById(R.id.permitNum);
            phone = (TextView) view.findViewById(R.id.phone);
            website = (TextView) view.findViewById(R.id.website);
            typeName = (TextView) view.findViewById(R.id.typeName);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);
        }
    }
}