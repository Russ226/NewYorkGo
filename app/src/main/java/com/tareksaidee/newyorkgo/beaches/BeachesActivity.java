package com.tareksaidee.newyorkgo.beaches;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.tareksaidee.newyorkgo.DTO.Beaches;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class BeachesActivity extends AppCompatActivity {

    private ArrayList<Beaches> beaches;
    private RecyclerView beachesView;
    private BeachesAdapter beachesAdapter;
    private JsonParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beaches);
        parser = new JsonParser();
        if (getIntent().getStringExtra("object") != null) {
            beaches = new ArrayList<>();
            beaches.add(new Gson().fromJson(getIntent().getStringExtra("object"), Beaches.class));
        } else {
            parser = new JsonParser();
            try {
                beaches = parser.getBeaches(getAssets());
            } catch (Exception e) {
                Log.e("Art gallery", e.getMessage());
            }
        }
        beachesView = findViewById(R.id.beachesRecyclerView);
        beachesAdapter = new BeachesAdapter(this, beaches);
        beachesView.setAdapter(beachesAdapter);
        beachesView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
