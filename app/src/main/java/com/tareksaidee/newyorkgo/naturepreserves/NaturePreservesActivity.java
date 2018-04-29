package com.tareksaidee.newyorkgo.naturepreserves;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tareksaidee.newyorkgo.DTO.NaturePreserves;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.artgallery.ArtGalleryAdapter;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class NaturePreservesActivity extends AppCompatActivity {

    //private ArrayList<ArtGallery> artGalleries;
    private ArrayList<NaturePreserves> N;
    //private RecyclerView artGalleriesView;
    private RecyclerView naturePreservesView;
    //private ArtGalleryAdapter artGalleryAdapter;
    private NaturePreservesAdapter naturePreservesAdapter;
    private JsonParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature_preserves);
        parser = new JsonParser();
        try {
            N = parser.getNaturePreserves(getAssets());
        } catch (Exception e) {
            Log.e("Nature Preserves", e.getMessage());
        }
        naturePreservesView = findViewById(R.id.naturePreservesActivity);
        naturePreservesAdapter = new NaturePreservesAdapter(this, N);
        naturePreservesView.setAdapter(naturePreservesAdapter);
        naturePreservesView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}