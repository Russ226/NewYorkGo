package com.tareksaidee.newyorkgo.sorter;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by russ on 4/28/18.
 */

public class DistanceAndLocation<T> {
    private T location;

    private Double distance;

    public DistanceAndLocation(T location, double distance) {
        this.location = location;
        this.distance = distance;
    }

    public T getLocation() {
        return location;
    }

    public void setLocation(T location) {
        this.location = location;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public static Comparator<DistanceAndLocation> COMPARE_BY_DISTANCE = new Comparator<DistanceAndLocation>() {
        public int compare(DistanceAndLocation one, DistanceAndLocation other) {
            return one.distance.compareTo(other.distance);
        }
    };


}
