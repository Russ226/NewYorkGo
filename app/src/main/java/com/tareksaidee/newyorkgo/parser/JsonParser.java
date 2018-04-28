package com.tareksaidee.newyorkgo.parser;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tareksaidee.newyorkgo.DTO.ArtGallery;
import com.tareksaidee.newyorkgo.DTO.BBQ;
import com.tareksaidee.newyorkgo.DTO.BasketballCourt;
import com.tareksaidee.newyorkgo.DTO.Beaches;
import com.tareksaidee.newyorkgo.DTO.DogRuns;
import com.tareksaidee.newyorkgo.DTO.Eateries;
import com.tareksaidee.newyorkgo.DTO.Handball;
import com.tareksaidee.newyorkgo.DTO.Hiking;
import com.tareksaidee.newyorkgo.DTO.IceSkating;
import com.tareksaidee.newyorkgo.DTO.IndoorSwimmingPool;
import com.tareksaidee.newyorkgo.DTO.Museum;
import com.tareksaidee.newyorkgo.DTO.NaturePreserves;
import com.tareksaidee.newyorkgo.DTO.OutdoorSwimming;
import com.tareksaidee.newyorkgo.DTO.Park;
import com.tareksaidee.newyorkgo.DTO.Tennis;
import com.tareksaidee.newyorkgo.DTO.Theater;
import com.tareksaidee.newyorkgo.DTO.ZooAqu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by russ on 4/28/18.
 */

public class JsonParser {
    private Gson gson;


    public JsonParser(){
        gson = new Gson();

    }

    public ArrayList<ArtGallery> getArtGAllery(AssetManager assetManager) throws IOException{
        String filePath = "artgallery.json";

        Type collectionType = new TypeToken<Collection<ArtGallery>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<ArtGallery> artGalleries = new ArrayList<>((Collection<? extends ArtGallery>) gson.fromJson(bufferedReader, collectionType));

        return artGalleries;

    }

    public ArrayList<BasketballCourt> getBasketballCourt(AssetManager assetManager) throws IOException{
        String filePath =  "basketball.json";

        Type collectionType = new TypeToken<Collection<BasketballCourt>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<BasketballCourt> basketballCourt = new ArrayList<>((Collection<? extends BasketballCourt>) gson.fromJson(bufferedReader, collectionType));

        return basketballCourt;

    }

    public ArrayList<BBQ> getBBQ(AssetManager assetManager) throws IOException{
        String filePath = "barbecue.json";

        Type collectionType = new TypeToken<Collection<BBQ>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<BBQ> bbqs = new ArrayList<>((Collection<? extends BBQ>) gson.fromJson(bufferedReader, collectionType));

        return bbqs;

    }

    public ArrayList<Beaches> getBeaches(AssetManager assetManager) throws IOException{
        String filePath = "beaches.json";

        Type collectionType = new TypeToken<Collection<Beaches>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<Beaches> beaches = new ArrayList<>((Collection<? extends Beaches>) gson.fromJson(bufferedReader, collectionType));

        return beaches;
    }

    public ArrayList<DogRuns> getDogRuns(AssetManager assetManager) throws IOException{
        String filePath = "dogruns.json";

        Type collectionType = new TypeToken<Collection<DogRuns>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<DogRuns> dogRuns = new ArrayList<>((Collection<? extends DogRuns>) gson.fromJson(bufferedReader, collectionType));

        return dogRuns;
    }

    public ArrayList<Eateries> getEateries(AssetManager assetManager) throws IOException{
        String filePath = "eateries.json";

        Type collectionType = new TypeToken<Collection<Eateries>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<Eateries> eateries = new ArrayList<>((Collection<? extends Eateries>) gson.fromJson(bufferedReader, collectionType));

        return eateries;
    }

    public ArrayList<Handball> getHandball(AssetManager assetManager) throws IOException{
        String filePath = "handball.json";

        Type collectionType = new TypeToken<Collection<Handball>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<Handball> handballs = new ArrayList<>((Collection<? extends Handball>) gson.fromJson(bufferedReader, collectionType));

        return handballs;
    }

    public ArrayList<Hiking> getHiking(AssetManager assetManager) throws IOException{
        String filePath = "hiking.json";

        Type collectionType = new TypeToken<Collection<Hiking>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<Hiking> hikings = new ArrayList<>((Collection<? extends Hiking>) gson.fromJson(bufferedReader, collectionType));

        return hikings;
    }

    public ArrayList<IceSkating> getIceSkating(AssetManager assetManager) throws IOException{
        String filePath = "iceskating.json";

        Type collectionType = new TypeToken<Collection<IceSkating>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<IceSkating> iceSkatings = new ArrayList<>((Collection<? extends IceSkating>) gson.fromJson(bufferedReader, collectionType));

        return iceSkatings;
    }

    public ArrayList<IndoorSwimmingPool> getIndoorSwimmingPool(AssetManager assetManager) throws IOException{
        String filePath = "pools_indoor.json";

        Type collectionType = new TypeToken<Collection<IndoorSwimmingPool>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<IndoorSwimmingPool> indoorSwimmingPools = new ArrayList<>((Collection<? extends IndoorSwimmingPool>) gson.fromJson(bufferedReader, collectionType));

        return indoorSwimmingPools;
    }

    public ArrayList<Museum> getMuseum(AssetManager assetManager) throws IOException{
        String filePath = "museum.json.json";

        Type collectionType = new TypeToken<Collection<Museum>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<Museum> museums = new ArrayList<>((Collection<? extends Museum>) gson.fromJson(bufferedReader, collectionType));

        return museums;
    }

    public ArrayList<NaturePreserves> getNaturePreserves(AssetManager assetManager) throws IOException{
        String filePath = "naturepreserves.json";

        Type collectionType = new TypeToken<Collection<NaturePreserves>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<NaturePreserves> naturePreserves = new ArrayList<>((Collection<? extends NaturePreserves>) gson.fromJson(bufferedReader, collectionType));

        return naturePreserves;
    }

    public ArrayList<OutdoorSwimming> getOutdoorSwimming(AssetManager assetManager) throws IOException{
        String filePath = "pools_outdoor.json";

        Type collectionType = new TypeToken<Collection<OutdoorSwimming>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<OutdoorSwimming> outdoorSwimmings = new ArrayList<>((Collection<? extends OutdoorSwimming>) gson.fromJson(bufferedReader, collectionType));

        return outdoorSwimmings;
    }

    public ArrayList<Park> getPark(AssetManager assetManager) throws IOException{
        String filePath = "parks.json";

        Type collectionType = new TypeToken<Collection<Tennis>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<Park> parks = new ArrayList<>((Collection<? extends Park>) gson.fromJson(bufferedReader, collectionType));

        return parks;
    }

    public ArrayList<Tennis> getTennis(AssetManager assetManager) throws IOException{
        String filePath = "tennis.json";

        Type collectionType = new TypeToken<Collection<Tennis>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<Tennis> tennises = new ArrayList<>((Collection<? extends Tennis>) gson.fromJson(bufferedReader, collectionType));

        return tennises;
    }

    public ArrayList<Theater> getTheater(AssetManager assetManager) throws IOException{
        String filePath = "theater.json";

        Type collectionType = new TypeToken<Collection<Theater>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<Theater> theaters = new ArrayList<>((Collection<? extends Theater>) gson.fromJson(bufferedReader, collectionType));

        return theaters;
    }

    public ArrayList<ZooAqu> getZooAqu(AssetManager assetManager) throws IOException {
        String filePath = "zooaqu.json";

        Type collectionType = new TypeToken<Collection<ZooAqu>>(){}.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(filePath)));

        ArrayList<ZooAqu> zooAqus = new ArrayList<>((List<? extends ZooAqu>) new Gson().fromJson(bufferedReader, collectionType));

        return zooAqus;

    }

}
