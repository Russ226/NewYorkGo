package com.tareksaidee.newyorkgo.museum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tareksaidee.newyorkgo.DTO.Museum;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class MuseumActivity extends AppCompatActivity {

    private ArrayList<Museum> M;
    private RecyclerView museumView;
    private MuseumAdapter museumAdapter;
    private JsonParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);
        parser = new JsonParser();
        try {
            M = parser.getMuseum(getAssets());
        } catch (Exception e) {
            Log.e("Museums", e.getMessage());
        }
        museumView = findViewById(R.id.museumRecyclerView);
        museumAdapter = new MuseumAdapter(this, M);
        museumView.setAdapter(museumAdapter);
        museumView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
