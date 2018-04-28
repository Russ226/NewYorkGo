package com.tareksaidee.newyorkgo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoview = (VideoView) findViewById(R.id.background_video);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.nycvid);
        videoview.setVideoURI(uri);
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        videoview.start();
    }

    public void handleButtons(View view){
        Intent intent = new Intent(this,HomescreenGridView.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoview.start();
    }
}
