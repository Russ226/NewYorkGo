package com.tareksaidee.newyorkgo.theater;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.tareksaidee.newyorkgo.DTO.Theater;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class TheaterActivity extends AppCompatActivity {

    private ArrayList<Theater> T;
    private RecyclerView theaterView;
    private TheaterAdapter theaterAdapter;
    private JsonParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);
        parser = new JsonParser();
        if (getIntent().getStringExtra("object") != null) {
            T = new ArrayList<>();
            T.add(new Gson().fromJson(getIntent().getStringExtra("object"), Theater.class));
        } else {
            parser = new JsonParser();
            try {
                T = parser.getTheater(getAssets());
            } catch (Exception e) {
                Log.e("Art gallery", e.getMessage());
            }
        }
        theaterView = findViewById(R.id.theaterRecyclerView);
        theaterAdapter = new TheaterAdapter(this, T);
        theaterView.setAdapter(theaterAdapter);
        theaterView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
