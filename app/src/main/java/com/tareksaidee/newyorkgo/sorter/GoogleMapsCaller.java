package com.tareksaidee.newyorkgo.sorter;

import android.location.Geocoder;

import com.google.maps.model.DistanceMatrix;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by russ on 4/28/18.
 */

public interface GoogleMapsCaller {
    String BASE_URL = "https://maps.googleapis.com/maps/api/distancematrix";

    @GET("/{distance}")
    Call<DistanceMatrix> getDistance(@Path(value = "distance", encoded = true) String distance);

}
