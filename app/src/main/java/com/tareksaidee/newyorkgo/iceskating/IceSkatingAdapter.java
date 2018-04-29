package com.tareksaidee.newyorkgo.iceskating;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.IceSkating;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.iceskating.IceSkatingActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class IceSkatingAdapter extends RecyclerView.Adapter<IceSkatingAdapter.IceSkatingViewHolder>{
    //ArrayList<BBQ> bbqs;
    ArrayList<IceSkating> I;
    private Context mContext;

    IceSkatingAdapter(@NonNull Context context, ArrayList<IceSkating> I) {
        mContext = context;
        this.I = I;
    }

    @Override
    public IceSkatingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bbq_card, parent, false);
        return new IceSkatingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IceSkatingViewHolder holder, int position) {
        IceSkating IS = I.get(position);

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
        }
    }
}
