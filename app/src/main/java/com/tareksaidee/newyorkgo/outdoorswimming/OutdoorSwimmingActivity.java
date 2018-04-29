package com.tareksaidee.newyorkgo.outdoorswimming;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.tareksaidee.newyorkgo.DTO.OutdoorSwimming;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class OutdoorSwimmingActivity extends AppCompatActivity {

    private ArrayList<OutdoorSwimming> OS;
    private RecyclerView outDoorSwimmingView;
    private OutdoorSwimmingAdapter outdoorSwimmingAdapter;
    private JsonParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor_swimming);
        parser = new JsonParser();
        if (getIntent().getStringExtra("object") != null) {
            OS = new ArrayList<>();
            OS.add(new Gson().fromJson(getIntent().getStringExtra("object"), OutdoorSwimming.class));
        } else {
            parser = new JsonParser();
            try {
                OS = parser.getOutdoorSwimming(getAssets());
            } catch (Exception e) {
                Log.e("Art gallery", e.getMessage());
            }
        }
        outDoorSwimmingView = findViewById(R.id.outdoorSwimmingActivity);
        outdoorSwimmingAdapter = new OutdoorSwimmingAdapter(this, OS);
        outDoorSwimmingView.setAdapter(outdoorSwimmingAdapter);
        outDoorSwimmingView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
