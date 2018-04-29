package com.tareksaidee.newyorkgo.theater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tareksaidee.newyorkgo.DTO.Theater;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;
import com.tareksaidee.newyorkgo.theater.TheaterAdapter;

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
        try {
            T = parser.getTheater(getAssets());
        } catch (Exception e) {
            Log.e("Theater", e.getMessage());
        }
        theaterView = findViewById(R.id.theaterRecyclerView);
        theaterAdapter = new TheaterAdapter(this, T);
        theaterView.setAdapter(theaterAdapter);
        theaterView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
