package com.tareksaidee.newyorkgo.park;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.tareksaidee.newyorkgo.DTO.Park;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class ParkActivity extends AppCompatActivity {

    //private ArrayList<Museum> M;
    private ArrayList<Park> P;
    //private RecyclerView museumView;
    private RecyclerView parkView;
    //private MuseumAdapter museumAdapter;
    private ParkAdapter parkAdapter;
    private JsonParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        parser = new JsonParser();
        if (getIntent().getStringExtra("object") != null) {
            P = new ArrayList<>();
            P.add(new Gson().fromJson(getIntent().getStringExtra("object"), Park.class));
        } else {
            parser = new JsonParser();
            try {
                P = parser.getPark(getAssets());
            } catch (Exception e) {
                Log.e("Art gallery", e.getMessage());
            }
        }
        parkView = findViewById(R.id.parkRecyclerView);
        parkAdapter = new ParkAdapter(this, P);
        parkView.setAdapter(parkAdapter);
        parkView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
