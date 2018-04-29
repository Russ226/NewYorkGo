package com.tareksaidee.newyorkgo.eateries;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.tareksaidee.newyorkgo.DTO.Eateries;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class EateriesActivity extends AppCompatActivity {

    private ArrayList<Eateries> E;
    private RecyclerView eateriesView;
    private EateriesAdapter eateriesAdapter;
    private JsonParser parser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eateries);
        parser = new JsonParser();
        if (getIntent().getStringExtra("object") != null) {
            E = new ArrayList<>();
            E.add(new Gson().fromJson(getIntent().getStringExtra("object"), Eateries.class));
        } else {
            parser = new JsonParser();
            try {
                E = parser.getEateries(getAssets());
            } catch (Exception e) {
                Log.e("Art gallery", e.getMessage());
            }
        }
        eateriesView = findViewById(R.id.eateriesRecyclerView);
        eateriesAdapter = new EateriesAdapter(this, E);
        eateriesView.setAdapter(eateriesAdapter);
        eateriesView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
}
