package com.tareksaidee.newyorkgo.indoorswimmingpool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.tareksaidee.newyorkgo.DTO.IndoorSwimmingPool;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class IndoorSwimmingPoolActivity extends AppCompatActivity {

    //private ArrayList<BBQ> bbqs;
    private ArrayList<IndoorSwimmingPool> ISP;
    //private RecyclerView bbqsView;
    private RecyclerView indoorSwimmingPoolView;
    //private BBQAdapter bbqAdapter;
    private IndoorSwimmingPoolAdapter ISPAdapter;
    private JsonParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indoor_swimming_pool);
        parser = new JsonParser();
        if (getIntent().getStringExtra("object") != null) {
            ISP = new ArrayList<>();
            ISP.add(new Gson().fromJson(getIntent().getStringExtra("object"), IndoorSwimmingPool.class));
        } else {
            parser = new JsonParser();
            try {
                ISP = parser.getIndoorSwimmingPool(getAssets());
            } catch (Exception e) {
                Log.e("Art gallery", e.getMessage());
            }
        }
        indoorSwimmingPoolView = findViewById(R.id.indoorSwimmingPoolRecyclerView);
        ISPAdapter = new IndoorSwimmingPoolAdapter(this, ISP);
        indoorSwimmingPoolView.setAdapter(ISPAdapter);
        indoorSwimmingPoolView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
