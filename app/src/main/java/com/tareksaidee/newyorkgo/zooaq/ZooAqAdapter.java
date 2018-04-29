package com.tareksaidee.newyorkgo.zooaq;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.ZooAqu;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;
import com.tareksaidee.newyorkgo.zooaq.ZooAqAdapter;

import java.util.ArrayList;

public class ZooAqAdapter extends RecyclerView.Adapter<ZooAqAdapter.ZooAqViewHolder> implements View.OnClickListener{
    ArrayList<ZooAqu> ZA;
    private Context mContext;

    ZooAqAdapter(@NonNull Context context, ArrayList<ZooAqu> ZA) {
        mContext = context;
        this.ZA = ZA;
    }

    @Override
    public ZooAqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.zoo_aqu_card, parent, false);
        return new ZooAqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ZooAqViewHolder holder, int position) {
        ZooAqu m = ZA.get(position);
        holder.name.setText(m.getName());
        holder.location.setText(m.getLocation());
        holder.phoneNum.setText(m.getPhoneNum());
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

        ZooAqViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            phoneNum = (TextView) view.findViewById(R.id.phone);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, ShowAddressActivity.class);
        intent.putExtra("address", ((TextView) view.findViewById(R.id.location)).getText().toString());
        mContext.startActivity(intent);
    }
}
