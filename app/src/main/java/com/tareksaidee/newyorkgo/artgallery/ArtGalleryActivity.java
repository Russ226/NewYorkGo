package com.tareksaidee.newyorkgo.artgallery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tareksaidee.newyorkgo.DTO.ArtGallery;
import com.tareksaidee.newyorkgo.R;

import java.util.ArrayList;

public class ArtGalleryActivity extends AppCompatActivity {

    private ArrayList<ArtGallery> artGalleries;
    private RecyclerView artGalleriesView;
    private ArtGalleryAdapter artGalleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_gallery);
        artGalleriesView = findViewById(R.id.artGalleryRecyclerView);
        artGalleryAdapter = new ArtGalleryAdapter(this,artGalleries);
        artGalleriesView.setAdapter(artGalleryAdapter);
        artGalleriesView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
