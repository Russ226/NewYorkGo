package com.tareksaidee.newyorkgo.zooaq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tareksaidee.newyorkgo.DTO.Theater;
import com.tareksaidee.newyorkgo.DTO.ZooAqu;
import com.tareksaidee.newyorkgo.R;
import com.tareksaidee.newyorkgo.parser.JsonParser;
import com.tareksaidee.newyorkgo.theater.TheaterAdapter;

import java.util.ArrayList;

public class ZooAqActivity extends AppCompatActivity {

    private ArrayList<ZooAqu> Z;
    private RecyclerView zooaqView;
    private ZooAqAdapter zooaqAdapter;
    private JsonParser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_aq);
        parser = new JsonParser();
        try {
            Z = parser.getZooAqu(getAssets());
        } catch (Exception e) {
            Log.e("ZooAq", e.getMessage());
        }
        zooaqView = findViewById(R.id.zooaqRecyclerView);
        zooaqAdapter = new ZooAqAdapter(this, Z);
        zooaqView.setAdapter(zooaqAdapter);
        zooaqView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
