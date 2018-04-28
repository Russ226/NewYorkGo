package com.tareksaidee.newyorkgo.bball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tareksaidee.newyorkgo.DTO.BasketballCourt;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class BasketballCourtActivity extends AppCompatActivity {

    private ArrayList<BasketballCourt> bball;
    private RecyclerView bballView;
    private BasketballCourtAdapter bballAdapter;

    private JsonParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball_court);
        parser = new JsonParser();
        try {
            bball = parser.getBasketballCourt(getAssets());
        } catch (Exception e) {
            Log.e("BasketballCourt", e.getMessage());
        }

        bballView = findViewById(R.id.basketballCourtRecyclerView);
        bballAdapter = new BasketballCourtAdapter(this, bball);
        bballView.setAdapter(bballAdapter);
        bballView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
