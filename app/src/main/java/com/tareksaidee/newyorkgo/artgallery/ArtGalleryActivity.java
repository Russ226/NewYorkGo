package com.tareksaidee.newyorkgo.artgallery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.tareksaidee.newyorkgo.DTO.ArtGallery;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class ArtGalleryActivity extends AppCompatActivity {

    private ArrayList<ArtGallery> artGalleries;
    private RecyclerView artGalleriesView;
    private ArtGalleryAdapter artGalleryAdapter;
    private JsonParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_gallery);
        if (getIntent().getStringExtra("object") != null) {
            artGalleries = new ArrayList<>();
            artGalleries.add(new Gson().fromJson(getIntent().getStringExtra("object"), ArtGallery.class));
        } else {
            parser = new JsonParser();
            try {
                artGalleries = parser.getArtGAllery(getAssets());
            } catch (Exception e) {
                Log.e("Art gallery", e.getMessage());
            }
        }
        artGalleriesView = findViewById(R.id.artGalleryRecyclerView);
        artGalleryAdapter = new ArtGalleryAdapter(this, artGalleries);
        artGalleriesView.setAdapter(artGalleryAdapter);
        artGalleriesView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
