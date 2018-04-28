package com.tareksaidee.newyorkgo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.Category;

import java.util.ArrayList;

/**
 * Created by tarek on 4/27/2018.
 */

public class HomescreenGridAdapter extends BaseAdapter{



    private Context mContext;

    private ArrayList<Category> categories;

    public HomescreenGridAdapter(Context mContext, ArrayList<Category> categories) {
        this.mContext = mContext;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
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
        final Category category = categories.get(i);
        if(view==null){
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            view = layoutInflater.inflate(R.layout.homescreen_grid_item, null);
        }
        ImageButton imageButton = view.findViewById(R.id.grid_item_image);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, category.getIntentClass()));
            }
        });
        TextView textView = view.findViewById(R.id.grid_image_text);
        imageButton.setBackground(category.getDrawable());
        textView.setText(category.getName());
        return view;
    }

    public ArrayList<Category> getCatagories() {
        return categories;
    }

    public void setCatagories(ArrayList<Category> catagories) {
        this.categories = catagories;
    }
}
