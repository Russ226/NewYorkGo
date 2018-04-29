package com.tareksaidee.newyorkgo.sorter;



import com.google.android.gms.maps.model.LatLng;
import com.google.maps.model.DistanceMatrix;
import com.tareksaidee.newyorkgo.DTO.Recreation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by russ on 4/28/18.
 */

public class LocationSorter <T extends Recreation>{
    private LatLng userLocation;

    private ArrayList<T> locations;

    private ArrayList<DistanceAndLocation> distances;

    public LocationSorter(LatLng userLocation, ArrayList<T> locations) {
        this.userLocation = userLocation;
        this.locations = locations;
    }

    public void findDistance() throws IOException {

        final DistanceMatrix distance = null;
        distances = new ArrayList<>();


        for(T recreation : locations){
            final String url;

            if(recreation.getAddress() != null){
                url = "json?units=imperial&origins=" + Double.toString(userLocation.latitude) + " " + Double.toString(userLocation.longitude) + "&destinations=" + recreation.getAddress() + "&key=AIzaSyAuqfgR3pZNmm1xQfBqS9OlXTqBkUMYRQ0";

            }else if(recreation.getAddress1() != null){
                url = "json?units=imperial&origins=" + Double.toString(userLocation.latitude) + " " + Double.toString(userLocation.longitude) + "&destinations=" + recreation.getAddress1() + "&key=AIzaSyAuqfgR3pZNmm1xQfBqS9OlXTqBkUMYRQ0";

            }else if(recreation.getAddress1() != null){
                url = "json?units=imperial&origins=" + Double.toString(userLocation.latitude) + " " + Double.toString(userLocation.longitude) + "&destinations=" + recreation.getAddress1() + "&key=AIzaSyAuqfgR3pZNmm1xQfBqS9OlXTqBkUMYRQ0";

            }else if(recreation.getLocation() != null){
                url = "json?units=imperial&origins=" + Double.toString(userLocation.latitude) + " " + Double.toString(userLocation.longitude) + "&destinations=" + recreation.getLocation() + "&key=AIzaSyAuqfgR3pZNmm1xQfBqS9OlXTqBkUMYRQ0";

            }else if(recreation.getName() != null){
                url = "json?units=imperial&origins=" + Double.toString(userLocation.latitude) + " " + Double.toString(userLocation.longitude) + "&destinations=" + recreation.getName() + "&key=AIzaSyAuqfgR3pZNmm1xQfBqS9OlXTqBkUMYRQ0";

            }else if(recreation.getParkName() != null){
                url = "json?units=imperial&origins=" + Double.toString(userLocation.latitude) + " " + Double.toString(userLocation.longitude) + "&destinations=" + recreation.getParkName() + "&key=AIzaSyAuqfgR3pZNmm1xQfBqS9OlXTqBkUMYRQ0";

            }else{
                url =null;
            }

            Thread  thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        callApi(url, distance);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });

            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            distances.add(new DistanceAndLocation(recreation, distance.rows[0].elements[0].distance.inMeters));

        }

        Collections.sort(distances, DistanceAndLocation.COMPARE_BY_DISTANCE);

    }

    public void callApi(String url, DistanceMatrix dist) throws IOException {
        OkHttpClient httpClient = new OkHttpClient();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(GoogleMapsCaller.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient);

        Retrofit retrofit = builder.build();
        GoogleMapsCaller requests = retrofit.create(GoogleMapsCaller.class);
        if(url != null){
            Call<DistanceMatrix> call = requests.getDistance(url);
            dist = call.execute().body();
        }else{
            dist = null;
        }

    }






}
