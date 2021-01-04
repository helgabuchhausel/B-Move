package com.example.myapplication;

class Card {
    private String name;
    private String description;
    private String website;

    Card(String name, String description, String website){
        this.name = name;
        this.description = description;
        this.website = website;
    }

    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
    public String getWebsite() { return this.website; }
}
