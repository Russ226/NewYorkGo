package com.tareksaidee.newyorkgo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class HomescreenGridView extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new HomescreenGridAdapter(this));
    }
}
