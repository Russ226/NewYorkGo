package com.tareksaidee.newyorkgo.bbq;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.BBQ;
import com.tareksaidee.newyorkgo.R;

import java.util.ArrayList;

/**
 * Created by tarek on 4/28/2018.
 */

public class BBQAdapter extends RecyclerView.Adapter<BBQAdapter.BBQViewHolder> {

    ArrayList<BBQ> bbqs;
    private Context mContext;

    BBQAdapter(@NonNull Context context, ArrayList<BBQ> bbqs) {
        mContext = context;
        this.bbqs = bbqs;

    }

    @Override
    public BBQAdapter.BBQViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.message_item, parent, false);
        return new BBQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BBQAdapter.BBQViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return bbqs.size();
    }

    void clear() {
        bbqs.clear();
    }

    class BBQViewHolder extends RecyclerView.ViewHolder {

        TextView userName;
        TextView messageText;
        PhotoView photoImageView;
        RoundedImageView userImage;

        BBQViewHolder(View view) {
            super(view);
            userName = (TextView) view.findViewById(R.id.nameTextView);
            messageText = (TextView) view.findViewById(R.id.messageTextView);
            photoImageView = (PhotoView) view.findViewById(R.id.photoImageView);
            userImage = (RoundedImageView) view.findViewById(R.id.user_image);
        }
    }


}
