package com.tareksaidee.newyorkgo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.tareksaidee.newyorkgo.DTO.Bookmark;
import com.tareksaidee.newyorkgo.artgallery.ArtGalleryActivity;
import com.tareksaidee.newyorkgo.bball.BasketballCourtActivity;
import com.tareksaidee.newyorkgo.bbq.BBQActivity;
import com.tareksaidee.newyorkgo.beaches.BeachesActivity;
import com.tareksaidee.newyorkgo.dogruns.DogRunsActivity;
import com.tareksaidee.newyorkgo.eateries.EateriesActivity;
import com.tareksaidee.newyorkgo.handball.HandballActivity;
import com.tareksaidee.newyorkgo.hiking.HikingActivity;
import com.tareksaidee.newyorkgo.iceskating.IceSkatingActivity;
import com.tareksaidee.newyorkgo.indoorswimmingpool.IndoorSwimmingPoolActivity;
import com.tareksaidee.newyorkgo.museum.MuseumActivity;
import com.tareksaidee.newyorkgo.naturepreserves.NaturePreservesActivity;
import com.tareksaidee.newyorkgo.outdoorswimming.OutdoorSwimmingActivity;
import com.tareksaidee.newyorkgo.park.ParkActivity;
import com.tareksaidee.newyorkgo.tennis.TennisActivity;
import com.tareksaidee.newyorkgo.theater.TheaterActivity;
import com.tareksaidee.newyorkgo.zooaq.ZooAqActivity;

import java.util.ArrayList;

/**
 * Created by tarek on 4/29/2018.
 */

public class BookmarksAdapter extends RecyclerView.Adapter<BookmarksAdapter.BookmarkViewHolder> {

    private ArrayList<Bookmark> bookmarks;
    private Context mContext;
    private Gson gson;

    public BookmarksAdapter(Context mContext, ArrayList<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
        this.mContext = mContext;
        gson = new Gson();
    }

    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bookmarks_item, parent, false);
        return new BookmarksAdapter.BookmarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {
        holder.name.setText(bookmarks.get(position).getName());
        final int pos = position;
        holder.detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                switch (bookmarks.get(pos).getClassName()) {
                    case "artgallery":
                        intent = new Intent(mContext, ArtGalleryActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "bball":
                        intent = new Intent(mContext, BasketballCourtActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "bbq":
                        intent = new Intent(mContext, BBQActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "beaches":
                        intent = new Intent(mContext, BeachesActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "dogruns":
                        intent = new Intent(mContext, DogRunsActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "eateries":
                        intent = new Intent(mContext, EateriesActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "handball":
                        intent = new Intent(mContext, HandballActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "hiking":
                        intent = new Intent(mContext, HikingActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "iceskating":
                        intent = new Intent(mContext, IceSkatingActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "indoorpool":
                        intent = new Intent(mContext, IndoorSwimmingPoolActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "museum":
                        intent = new Intent(mContext, MuseumActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "naturepreserves":
                        intent = new Intent(mContext, NaturePreservesActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "outdoorpool":
                        intent = new Intent(mContext, OutdoorSwimmingActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "park":
                        intent = new Intent(mContext, ParkActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "tennis":
                        intent = new Intent(mContext, TennisActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "theater":
                        intent = new Intent(mContext, TheaterActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                    case "zooaq":
                        intent = new Intent(mContext, ZooAqActivity.class);
                        intent.putExtra("object", gson.toJson(bookmarks.get(pos)));
                        mContext.startActivity(intent);
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return bookmarks.size();
    }

    public void clear(){
        bookmarks.clear();
    }

    void add(Bookmark bookmark) {
        bookmarks.add(bookmark);
    }

    class BookmarkViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        Button detailsButton;

        BookmarkViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            detailsButton = (Button) view.findViewById(R.id.details_button);
        }
    }
}
