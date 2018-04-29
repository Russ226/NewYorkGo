package com.tareksaidee.newyorkgo.naturepreserves;

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
import com.tareksaidee.newyorkgo.DTO.NaturePreserves;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;
import java.util.Random;

public class NaturePreservesAdapter extends RecyclerView.Adapter<NaturePreservesAdapter.NaturePreservesViewHolder> {
    ArrayList<NaturePreserves> naturePreserves;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;

    NaturePreservesAdapter(@NonNull Context context, ArrayList<NaturePreserves> naturePreserves) {
        mContext = context;
        this.naturePreserves = naturePreserves;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public NaturePreservesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.nature_preserves_card, parent, false);
        return new NaturePreservesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NaturePreservesViewHolder holder, int position) {
        final NaturePreserves NP = naturePreserves.get(position);
        holder.parkId.setText(NP.getParkId());
        holder.parkName.setText(NP.getParkName());
        holder.sanctuaryName.setText(NP.getSanctuaryName());
        holder.borough.setText(NP.getBorough());
        holder.acres.setText(NP.getAcres());
        holder.directions.setText(NP.getDirections());
        holder.description.setText(NP.getDescription());
        holder.habitatType.setText(NP.getHabitatType());

        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(NP);
                    Bookmark bookmark = new Bookmark(NP.getName(), key, "naturepreserves");
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
                intent.putExtra("address", NP.getLocation());
                mContext.startActivity(intent);
            }
        });
        if(getItemCount()==1){
            holder.bookmarkButton.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return naturePreserves.size();
    }

    void clear() {
        naturePreserves.clear();
    }

    class NaturePreservesViewHolder extends RecyclerView.ViewHolder {

        TextView parkId;
        TextView parkName;
        TextView sanctuaryName;
        TextView borough;
        TextView acres;
        TextView directions;
        TextView description;
        TextView habitatType;
        Button mapButton;
        Button bookmarkButton;


        NaturePreservesViewHolder(View view) {
            super(view);
            parkId = (TextView) view.findViewById(R.id.parkID);
            parkName = (TextView) view.findViewById(R.id.parkName);
            sanctuaryName = (TextView) view.findViewById(R.id.san);
            borough = (TextView) view.findViewById(R.id.bor);
            acres = (TextView) view.findViewById(R.id.acre);
            directions = (TextView) view.findViewById(R.id.directions);
            description = (TextView) view.findViewById(R.id.description);
            habitatType = (TextView) view.findViewById(R.id.hab);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);
        }
    }
}
