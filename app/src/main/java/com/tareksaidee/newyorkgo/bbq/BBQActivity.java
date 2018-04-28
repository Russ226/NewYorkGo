package com.tareksaidee.newyorkgo.bbq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tareksaidee.newyorkgo.DTO.BBQ;
import com.tareksaidee.newyorkgo.R;

import java.util.ArrayList;

public class BBQActivity extends AppCompatActivity {

    private ArrayList<BBQ> bbqs;
    private RecyclerView bbqsView;
    private BBQAdapter bbqAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbq);
        bbqsView = findViewById(R.id.bbqRecyclerView);
        bbqAdapter = new BBQAdapter(this, bbqs);
        bbqsView.setAdapter(bbqAdapter);
        bbqsView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
}
