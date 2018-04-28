package com.tareksaidee.newyorkgo.eateries;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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
        try {
            E = parser.getEateries(getAssets());
        } catch (Exception e) {
            Log.e("Eateries", e.getMessage());
        }
        eateriesView = findViewById(R.id.eateriesRecyclerView);
        eateriesAdapter = new EateriesAdapter(this, E);
        eateriesView.setAdapter(eateriesAdapter);
        eateriesView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
}
