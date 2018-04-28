package com.tareksaidee.newyorkgo.DTO;

import android.graphics.drawable.Drawable;

/**
 * Created by tarek on 4/28/2018.
 */

public class Category {

    private String name;

    private Drawable drawable;

    private Class intentClass;

    public Category(String name, Drawable drawable, Class intentClass) {
        this.name = name;
        this.drawable = drawable;
        this.intentClass = intentClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public Class getIntentClass() {
        return intentClass;
    }

    public void setIntentClass(Class intentClass) {
        this.intentClass = intentClass;
    }
}
