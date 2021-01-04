package com.example.myapplication;

import android.net.Uri;

import java.net.URI;

class City {
    private String name;
    private long population;
    private String website;
    private Uri image;

    City(String name, long population, String website, Uri image){
        this.name = name;
        this.population = population;
        this.website = website;
        this.image = image;
    }

    public String getName() { return name; }
    public long getPopulation() { return population; }
    public Uri getImage(){return  image;}
    public String getWebsite() { return website; }

}
