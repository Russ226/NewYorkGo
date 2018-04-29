package com.tareksaidee.newyorkgo.beaches;

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
import com.tareksaidee.newyorkgo.DTO.Beaches;
import com.tareksaidee.newyorkgo.DTO.Bookmark;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;
import java.util.Random;

public class BeachesAdapter extends RecyclerView.Adapter<BeachesAdapter.BeachesViewHolder>{

    ArrayList<Beaches> beaches;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;

    BeachesAdapter(@NonNull Context context, ArrayList<Beaches> beaches) {
        mContext = context;
        this.beaches = beaches;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public BeachesAdapter.BeachesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.beach_card, parent, false);
        return new BeachesAdapter.BeachesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeachesAdapter.BeachesViewHolder holder, int position) {
        final Beaches beach = beaches.get(position);
        //holder.location.setText(beach.getLocation());
        holder.name.setText(beach.getName());
        holder.phone.setText(beach.getPhone());
        holder.surf.setText(beach.getSurf());
        holder.note.setText(beach.getNote());
        holder.accessible.setText(beach.getAccessible());
        holder.accesibleNote.setText(beach.getAccessibleNotes());
        holder.barbecue.setText(beach.getBarbecueAllowed());
        holder.bathroom.setText(beach.getBathroom());
        holder.bikeSkate.setText(beach.getBicycleAndSkatePath());
        holder.boardWalk.setText(beach.getBoardwalk());
        holder.description.setText(beach.getDescription());
        holder.location.setText(beach.getLocation());
        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(beach);
                    Bookmark bookmark = new Bookmark(beach.getName(), key);
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
                intent.putExtra("address", beach.getLocation());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return beaches.size();
    }

    void clear() {
        beaches.clear();
    }

    class BeachesViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView location;
        TextView phone;
        TextView surf;
        TextView note;
        TextView accessible;
        TextView accesibleNote;
        TextView barbecue;
        TextView bathroom;
        TextView bikeSkate;
        TextView boardWalk;
        TextView description;
        Button mapButton;
        Button bookmarkButton;

        BeachesViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            phone = (TextView) view.findViewById(R.id.phone);
            surf = (TextView) view.findViewById(R.id.surf);
            note = (TextView) view.findViewById(R.id.note);
            accessible = (TextView) view.findViewById(R.id.accessible);
            accesibleNote = (TextView) view.findViewById(R.id.accessibleNotes);
            barbecue = (TextView) view.findViewById(R.id.bbqOK);
            bathroom = (TextView) view.findViewById(R.id.bathroom);
            bikeSkate = (TextView) view.findViewById(R.id.bikeAndSkate);
            boardWalk = (TextView) view.findViewById(R.id.boardwalk);
            description = (TextView) view.findViewById(R.id.description);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);
        }
    }
}
