package com.tareksaidee.newyorkgo.artgallery;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.ArtGallery;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.ShowAddressActivity;

import java.util.ArrayList;

/**
 * Created by tarek on 4/28/2018.
 */

public class ArtGalleryAdapter extends RecyclerView.Adapter<ArtGalleryAdapter.ArtGalleryViewHolder> implements View.OnClickListener {

    ArrayList<ArtGallery> artGalleries;
    private Context mContext;

    ArtGalleryAdapter(@NonNull Context context, ArrayList<ArtGallery> artGalleries) {
        mContext = context;
        this.artGalleries = artGalleries;

    }

    @Override
    public ArtGalleryAdapter.ArtGalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.art_gallery_card, parent, false);
        view.setOnClickListener(this);
        return new ArtGalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArtGalleryAdapter.ArtGalleryViewHolder holder, int position) {
        ArtGallery gallery = artGalleries.get(position);
        holder.name.setText(gallery.getName());
        holder.telephone.setText(gallery.getTel());
        holder.url.setText(gallery.getUrl());
        holder.address.setText(gallery.getAddress1() + "\n" + gallery.getAddress2());
        holder.city.setText(gallery.getCity());
        holder.zipcode.setText(gallery.getZipCode());
    }

    @Override
    public int getItemCount() {
        return artGalleries.size();
    }

    void clear() {
        artGalleries.clear();
    }

    class ArtGalleryViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView telephone;
        TextView url;
        TextView address;
        TextView city;
        TextView zipcode;

        ArtGalleryViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            telephone = (TextView) view.findViewById(R.id.phone);
            url = (TextView) view.findViewById(R.id.url);
            address = (TextView) view.findViewById(R.id.address);
            city = (TextView) view.findViewById(R.id.city);
            zipcode = (TextView) view.findViewById(R.id.zip);
        }


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, ShowAddressActivity.class);
        intent.putExtra("address", ((TextView) view.findViewById(R.id.address)).getText().toString());
        mContext.startActivity(intent);
    }
}
