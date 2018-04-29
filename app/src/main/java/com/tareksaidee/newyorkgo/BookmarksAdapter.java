package com.tareksaidee.newyorkgo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tareksaidee.newyorkgo.DTO.Bookmark;

import java.util.ArrayList;

/**
 * Created by tarek on 4/29/2018.
 */

public class BookmarksAdapter extends RecyclerView.Adapter<BookmarksAdapter.BookmarkViewHolder> {

    private ArrayList<Bookmark> bookmarks;
    private Context mContext;

    public BookmarksAdapter(Context mContext, ArrayList<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
        this.mContext = mContext;
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
    }

    @Override
    public int getItemCount() {
        return bookmarks.size();
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
            detailsButton = (Button) view.findViewById(R.id.email_button);
        }
    }
}
