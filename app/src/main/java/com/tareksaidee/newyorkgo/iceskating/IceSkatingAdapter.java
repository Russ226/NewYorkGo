package com.tareksaidee.newyorkgo.iceskating;

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
import com.tareksaidee.newyorkgo.DTO.IceSkating;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;
import com.tareksaidee.newyorkgo.iceskating.IceSkatingActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class IceSkatingAdapter extends RecyclerView.Adapter<IceSkatingAdapter.IceSkatingViewHolder> {

    ArrayList<IceSkating> I;
    private Context mContext;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBookmarksDatabaseReferenceFull;
    private DatabaseReference mBookmarksDatabaseReferencePart;
    private FirebaseAuth mFirebaseAuth;

    IceSkatingAdapter(@NonNull Context context, ArrayList<IceSkating> I) {
        mContext = context;
        this.I = I;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mBookmarksDatabaseReferenceFull = mFirebaseDatabase.getReference();
        mBookmarksDatabaseReferencePart = mFirebaseDatabase.getReference();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public IceSkatingAdapter.IceSkatingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.ice_skating_card, parent, false);
        return new IceSkatingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IceSkatingViewHolder holder, int position) {
        final IceSkating IS = I.get(position);
        holder.name.setText(IS.getName());
        holder.location.setText(IS.getLocation());
        holder.phone.setText(IS.getPhone());
        holder.accessible.setText(IS.getAccessible());
        holder.type.setText(IS.getType());
        holder.publicSkateAdmissionPriceAdult.setText(IS.getPublicSkateAdmissionPriceAdult());
        holder.publicSkateAdmissionPriceChild.setText(IS.getPublicSkateAdmissionPriceChild());
        holder.publicSkateAdmissionPriceSenior.setText(IS.getPublicSkateAdmissionPriceSenior());
        holder.openingDate.setText(IS.getOpeningDate());
        holder.closingDate.setText(IS.getClosingDate());
        holder.sundayPublicSkatingHours.setText(IS.getSundayPublicSkatingHours());
        holder.mondayPublicSkatingHours.setText(IS.getMondayPublicSkatingHours());
        holder.tuesdayPublicSkatingHours.setText(IS.getTuesdayPublicSkatingHours());
        holder.wednesdayPublicSkatingHours.setText(IS.getWednesdayPublicSkatingHours());
        holder.thursdayPublicSkatingHours.setText(IS.getThursdayPublicSkatingHours());
        holder.fridayPublicSkatingHours.setText(IS.getFridayPublicSkatingHours());
        holder.saturdayPublicSkatingHours.setText(IS.getSaturdayPublicSkatingHours());
        holder.holidayPublicSkatingHours.setText(IS.getHolidayPublicSkatingHours());
        holder.programming.setText(IS.getProgramming());
        holder.notes.setText(IS.getNotes());

        holder.bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFirebaseAuth.getCurrentUser() != null) {
                    String key = (new Random().nextInt(100000000)) + "";
                    mBookmarksDatabaseReferenceFull.child(mFirebaseAuth.getCurrentUser().getUid() + "/full/" + key)
                            .push().setValue(IS);
                    Bookmark bookmark = new Bookmark(IS.getName(), key, "iceskating");
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
                intent.putExtra("address", IS.getLocation());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return I.size();
    }

    void clear() {
        I.clear();
    }

    class IceSkatingViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView location;
        TextView phone;
        TextView accessible;
        TextView type;
        TextView publicSkateAdmissionPriceAdult;
        TextView publicSkateAdmissionPriceChild;
        TextView publicSkateAdmissionPriceSenior;
        TextView openingDate;
        TextView closingDate;
        TextView sundayPublicSkatingHours;
        TextView mondayPublicSkatingHours;
        TextView tuesdayPublicSkatingHours;
        TextView wednesdayPublicSkatingHours;
        TextView thursdayPublicSkatingHours;
        TextView fridayPublicSkatingHours;
        TextView saturdayPublicSkatingHours;
        TextView holidayPublicSkatingHours;
        TextView programming;
        TextView notes;
        Button mapButton;
        Button bookmarkButton;

        IceSkatingViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            phone = (TextView) view.findViewById(R.id.phone);
            accessible = (TextView) view.findViewById(R.id.accessible);
            type = (TextView) view.findViewById(R.id.type);
            publicSkateAdmissionPriceAdult = (TextView) view.findViewById(R.id.admissionPriceAdult);
            publicSkateAdmissionPriceChild = (TextView) view.findViewById(R.id.admissionPriceChild);
            publicSkateAdmissionPriceSenior = (TextView) view.findViewById(R.id.admissionPriceSenior);
            openingDate = (TextView) view.findViewById(R.id.openingDate);
            closingDate = (TextView) view.findViewById(R.id.closingDate);
            sundayPublicSkatingHours = (TextView) view.findViewById(R.id.sundayHours);
            mondayPublicSkatingHours = (TextView) view.findViewById(R.id.mondayHours);
            tuesdayPublicSkatingHours = (TextView) view.findViewById(R.id.tuesdayHours);
            wednesdayPublicSkatingHours = (TextView) view.findViewById(R.id.wednesdayHours);
            thursdayPublicSkatingHours = (TextView) view.findViewById(R.id.ThursdayHours);
            fridayPublicSkatingHours = (TextView) view.findViewById(R.id.fridayHours);
            saturdayPublicSkatingHours = (TextView) view.findViewById(R.id.saturdayHours);
            holidayPublicSkatingHours = (TextView) view.findViewById(R.id.holidayHours);
            programming = (TextView) view.findViewById(R.id.programming);
            notes = (TextView) view.findViewById(R.id.notes);
            mapButton = (Button) view.findViewById(R.id.map);
            bookmarkButton = (Button) view.findViewById(R.id.bookmark);
        }
    }
}
