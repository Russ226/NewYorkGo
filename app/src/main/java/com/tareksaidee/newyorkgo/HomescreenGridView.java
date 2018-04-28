package com.tareksaidee.newyorkgo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class HomescreenGridView extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new HomescreenGridAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(HomescreenGridView.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
