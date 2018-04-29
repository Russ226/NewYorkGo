package com.tareksaidee.newyorkgo.dogruns;

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
import com.tareksaidee.newyorkgo.DTO.DogRuns;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;
import java.util.Random;

public class DogRunsAdapter extends RecyclerView.Adapter<DogRunsAdapter.DogRunsViewHolder> {
    ArrayList<DogRuns> dogRuns;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;

    DogRunsAdapter(@NonNull Context context, ArrayList<DogRuns> dogRuns) {
        mContext = context;
        this.dogRuns = dogRuns;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public DogRunsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dog_runs_card, parent, false);
        return new DogRunsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DogRunsViewHolder holder, int position) {
        final DogRuns d = dogRuns.get(position);
        holder.name.setText(d.getName());
        holder.address.setText(d.getName());
        holder.dogRunsType.setText(d.getName());
        holder.accessible.setText(d.getName());
        holder.notes.setText(d.getName());

        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(d);
                    Bookmark bookmark = new Bookmark(d.getName(), key, "dogruns");
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
                intent.putExtra("address", d.getLocation());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dogRuns.size();
    }

    void clear() {
        dogRuns.clear();
    }


    class DogRunsViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView address;
        TextView dogRunsType;
        TextView accessible;
        TextView notes;
        Button mapButton;
        Button bookmarkButton;

        DogRunsViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            address = (TextView) view.findViewById(R.id.address);
            dogRunsType = (TextView) view.findViewById(R.id.dogRunType);
            accessible = (TextView) view.findViewById(R.id.accessible);
            notes = (TextView) view.findViewById(R.id.notes);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);
        }
    }
}

