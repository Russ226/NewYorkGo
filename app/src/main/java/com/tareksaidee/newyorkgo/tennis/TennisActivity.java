package com.tareksaidee.newyorkgo.tennis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.tareksaidee.newyorkgo.DTO.Tennis;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class TennisActivity extends AppCompatActivity {

    private ArrayList<Tennis> T;
    private RecyclerView tennisView;
    private TennisAdapter tennisAdapter;
    private JsonParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tennis);
        parser = new JsonParser();
        if (getIntent().getStringExtra("object") != null) {
            T = new ArrayList<>();
            T.add(new Gson().fromJson(getIntent().getStringExtra("object"), Tennis.class));
        } else {
            parser = new JsonParser();
            try {
                T = parser.getTennis(getAssets());
            } catch (Exception e) {
                Log.e("Art gallery", e.getMessage());
            }
        }
        tennisView = findViewById(R.id.tennisActivity);
        tennisAdapter = new TennisAdapter(this, T);
        tennisView.setAdapter(tennisAdapter);
        tennisView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
