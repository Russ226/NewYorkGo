package com.tareksaidee.newyorkgo.zooaq;

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
import com.tareksaidee.newyorkgo.DTO.ZooAqu;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;
import java.util.Random;

public class ZooAqAdapter extends RecyclerView.Adapter<ZooAqAdapter.ZooAqViewHolder> {
    ArrayList<ZooAqu> ZA;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;

    ZooAqAdapter(@NonNull Context context, ArrayList<ZooAqu> ZA) {
        mContext = context;
        this.ZA = ZA;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public ZooAqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.zoo_aqu_card, parent, false);
        return new ZooAqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ZooAqViewHolder holder, int position) {
        final ZooAqu m = ZA.get(position);
        holder.name.setText(m.getName());
        holder.location.setText(m.getLocation());
        holder.phoneNum.setText(m.getPhoneNum());
        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(m);
                    Bookmark bookmark = new Bookmark(m.getName(), key, "zooaq","350 5th Ave");
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
        return ZA.size();
    }

    void clear() {
        ZA.clear();
    }

    class ZooAqViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView location;
        TextView phoneNum;
        Button mapButton;
        Button bookmarkButton;

        ZooAqViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            phoneNum = (TextView) view.findViewById(R.id.phone);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);
        }
    }
}
