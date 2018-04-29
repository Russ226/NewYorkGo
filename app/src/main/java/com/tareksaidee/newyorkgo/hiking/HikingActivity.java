package com.tareksaidee.newyorkgo.hiking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.tareksaidee.newyorkgo.DTO.Hiking;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class HikingActivity extends AppCompatActivity {

    private ArrayList<Hiking> H;
    private RecyclerView hikingView;
    private HikingAdapter hikingAdapter;
    private JsonParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiking);
        parser = new JsonParser();
        if (getIntent().getStringExtra("object") != null) {
            H = new ArrayList<>();
            H.add(new Gson().fromJson(getIntent().getStringExtra("object"), Hiking.class));
        } else {
            parser = new JsonParser();
            try {
                H = parser.getHiking(getAssets());
            } catch (Exception e) {
                Log.e("Art gallery", e.getMessage());
            }
        }
        hikingView = findViewById(R.id.hikingRecyclerView);
        hikingAdapter = new HikingAdapter(this, H);
        hikingView.setAdapter(hikingAdapter);
        hikingView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
