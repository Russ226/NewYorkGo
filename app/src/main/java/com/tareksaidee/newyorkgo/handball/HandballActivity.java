package com.tareksaidee.newyorkgo.handball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.tareksaidee.newyorkgo.DTO.Handball;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;

import java.util.ArrayList;

public class HandballActivity extends AppCompatActivity {

    private ArrayList<Handball> H;
    private RecyclerView handballView;
    private HandballAdapter handballAdapter;
    private JsonParser parser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handball);
        parser = new JsonParser();
        if (getIntent().getStringExtra("object") != null) {
            H = new ArrayList<>();
            H.add(new Gson().fromJson(getIntent().getStringExtra("object"), Handball.class));
        } else {
            parser = new JsonParser();
            try {
                H = parser.getHandball(getAssets());
            } catch (Exception e) {
                Log.e("Art gallery", e.getMessage());
            }
        }
        handballView = findViewById(R.id.handballRecyclerView);
        handballAdapter = new HandballAdapter(this, H);
        handballView.setAdapter(handballAdapter);
        handballView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
