package com.tareksaidee.newyorkgo;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.tareksaidee.newyorkgo.DTO.Category;
import com.tareksaidee.newyorkgo.DTO.IndoorSwimmingPool;
import com.tareksaidee.newyorkgo.artgallery.ArtGalleryActivity;
import com.tareksaidee.newyorkgo.bball.BasketballCourtActivity;
import com.tareksaidee.newyorkgo.bbq.BBQActivity;
import com.tareksaidee.newyorkgo.beaches.BeachesActivity;
import com.tareksaidee.newyorkgo.dogruns.DogRunsActivity;
import com.tareksaidee.newyorkgo.eateries.EateriesActivity;
import com.tareksaidee.newyorkgo.handball.HandballActivity;
import com.tareksaidee.newyorkgo.hiking.HikingActivity;
import com.tareksaidee.newyorkgo.iceskating.IceSkatingActivity;
import com.tareksaidee.newyorkgo.indoorswimmingpool.IndoorSwimmingPoolActivity;
import com.tareksaidee.newyorkgo.naturepreserves.NaturePreservesActivity;
import com.tareksaidee.newyorkgo.outdoorswimming.OutdoorSwimmingActivity;
import com.tareksaidee.newyorkgo.park.ParkActivity;
import com.tareksaidee.newyorkgo.tennis.TennisActivity;
import com.tareksaidee.newyorkgo.theater.TheaterActivity;
import com.tareksaidee.newyorkgo.zooaq.ZooAqActivity;

import java.util.ArrayList;

public class HomescreenGridView extends AppCompatActivity {

    private ArrayList<Category> categories;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        categories = new ArrayList<>();
        getData();
        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new HomescreenGridAdapter(this, categories));
        //gridview.setLayoutParams(new RelativeLayout.LayoutParams(GridView.AUTO_FIT,GridView.AUTO_FIT));
    }

    private void getData() {
        Category category = new Category("Art Galleries", ContextCompat.getDrawable(this, R.drawable.artgallery), ArtGalleryActivity.class);
        categories.add(category);
        category = new Category("Basketball Courts", ContextCompat.getDrawable(this, R.drawable.basketball), BasketballCourtActivity.class);
        categories.add(category);
        category = new Category("BBQ Spots", ContextCompat.getDrawable(this, R.drawable.bbqimage), BBQActivity.class);
        categories.add(category);
        category = new Category("Beaches", ContextCompat.getDrawable(this, R.drawable.beaches), BeachesActivity.class);
        categories.add(category);
        category = new Category("Dog Runs", ContextCompat.getDrawable(this, R.drawable.dogs), DogRunsActivity.class);
        categories.add(category);
        category = new Category("Eateries", ContextCompat.getDrawable(this, R.drawable.eateries), EateriesActivity.class);
        categories.add(category);
        category = new Category("Handball", ContextCompat.getDrawable(this, R.drawable.handball_courts), HandballActivity.class);
        categories.add(category);
        category = new Category("Hiking", ContextCompat.getDrawable(this, R.drawable.hiking), HikingActivity.class);
        categories.add(category);
        category = new Category("Ice Skating", ContextCompat.getDrawable(this, R.drawable.iceskating), IceSkatingActivity.class);
        categories.add(category);
        category = new Category("Indoor Swimming Pool", ContextCompat.getDrawable(this, R.drawable.indoorswimming), IndoorSwimmingPoolActivity.class);
        categories.add(category);
        category = new Category("Nature Preserves", ContextCompat.getDrawable(this, R.drawable.nature), NaturePreservesActivity.class);
        categories.add(category);
        category = new Category("Outdoor Swimming", ContextCompat.getDrawable(this, R.drawable.outdoorswimming),OutdoorSwimmingActivity.class);
        categories.add(category);
        category = new Category("Parks", ContextCompat.getDrawable(this, R.drawable.parks), ParkActivity.class);
        categories.add(category);
        category = new Category("Tennis Courts", ContextCompat.getDrawable(this, R.drawable.tenniscourts), TennisActivity.class);
        categories.add(category);
        category = new Category("Theaters", ContextCompat.getDrawable(this, R.drawable.theaters), TheaterActivity.class);
        categories.add(category);
        category = new Category("Zoo and Aquarium", ContextCompat.getDrawable(this, R.drawable.aquariums), ZooAqActivity.class);
        categories.add(category);
    }


}
