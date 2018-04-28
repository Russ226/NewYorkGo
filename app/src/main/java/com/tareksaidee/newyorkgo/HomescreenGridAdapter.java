package com.tareksaidee.newyorkgo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by tarek on 4/27/2018.
 */

public class HomescreenGridAdapter extends BaseAdapter {



    private Context mContext;

    public HomescreenGridAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            view = layoutInflater.inflate(R.layout.homescreen_grid_item, null);
        }
        ImageButton imageButton = view.findViewById(R.id.grid_item_image);
        TextView textView = view.findViewById(R.id.grid_image_text);
        imageButton.setBackgroundResource(R.drawable.nature);
        textView.setText("Ssadsada");
        return view;
    }
}
