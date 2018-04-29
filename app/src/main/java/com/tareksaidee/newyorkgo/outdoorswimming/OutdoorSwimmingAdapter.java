package com.tareksaidee.newyorkgo.outdoorswimming;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tareksaidee.newyorkgo.DTO.OutdoorSwimming;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;

public class OutdoorSwimmingAdapter extends RecyclerView.Adapter<OutdoorSwimmingAdapter.OutdoorSwimmingPoolViewHolder> implements View.OnClickListener {

    ArrayList<OutdoorSwimming> ODS;
    private Context mContext;

    OutdoorSwimmingAdapter(@NonNull Context context, ArrayList<OutdoorSwimming> ODS) {
        mContext = context;
        this.ODS = ODS;
    }

    @Override
    public OutdoorSwimmingPoolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.outdoor_swimming, parent, false);
        view.setOnClickListener(this);
        return new OutdoorSwimmingPoolViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OutdoorSwimmingPoolViewHolder holder, int position) {
        OutdoorSwimming O = ODS.get(position);
        holder.name.setText(O.getName());
        holder.phone.setText(O.getPhone());
        holder.poolsOutdoorType.setText(O.getPoolsOutdoorType());
        holder.setting.setText(O.getSetting());
        holder.size.setText(O.getSize());
        holder.lat.setText(O.getLat());
        holder.longitude.setText(O.getLongitude());
        holder.recCenterId.setText(O.getRecCenterId());
    }

    @Override
    public int getItemCount() {
        return ODS.size();
    }

    void clear() {
        ODS.clear();
    }

    class OutdoorSwimmingPoolViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView phone;
        TextView poolsOutdoorType;
        TextView setting;
        TextView size;
        TextView lat;
        TextView longitude;
        TextView recCenterId;

        OutdoorSwimmingPoolViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            phone = (TextView) view.findViewById(R.id.phone);
            poolsOutdoorType = (TextView) view.findViewById(R.id.poolOutdoorType);
            setting = (TextView) view.findViewById(R.id.setting);
            size = (TextView) view.findViewById(R.id.size);
            lat = (TextView) view.findViewById(R.id.lat);
            longitude = (TextView) view.findViewById(R.id.longitude);
            recCenterId = (TextView) view.findViewById(R.id.recCenterID);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, ShowAddressActivity.class);
        intent.putExtra("address", ((TextView) view.findViewById(R.id.address)).getText().toString());
        mContext.startActivity(intent);
    }
}
