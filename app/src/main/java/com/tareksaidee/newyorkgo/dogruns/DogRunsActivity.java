package com.tareksaidee.newyorkgo.dogruns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tareksaidee.newyorkgo.DTO.DogRuns;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class DogRunsActivity extends AppCompatActivity {

    private ArrayList<DogRuns> DR;
    private RecyclerView dogRunsView;
    private DogRunsAdapter dogRunsAdapter;
    private JsonParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_runs);
        parser = new JsonParser();
        try {
            DR = parser.getDogRuns(getAssets());
        } catch (Exception e) {
            Log.e("Dog Runs", e.getMessage());
        }
        dogRunsView = findViewById(R.id.dogrunsRecycler);
        dogRunsAdapter = new DogRunsAdapter(this, DR);
        dogRunsView.setAdapter(dogRunsAdapter);
        dogRunsView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}

