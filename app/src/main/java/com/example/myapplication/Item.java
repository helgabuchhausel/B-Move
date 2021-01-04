package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "item_table")
class Item {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "item")
    private String text;

    private String time;
    private String goalTime;

    /*
    public Item(String id, String text, String time, String goalTime){
        this.id = id;
        this.text = text;
        this.time = time;
        this.goalTime = goalTime;
    }

    public Item(String id, String text, String time){
        this.id = id;
        this.text = text;
        this.time = time;
    }

    public Item(String id, String text){
        this.id = id;
        this.text = text;
    }
*/
    public Item(String text){
        this.text = text;
    }

    public String getText(){return  this.text;}
    public String getTime(){return  this.time;}
    public String getGoalTime(){return  this.goalTime;}


    public void setText(String text){this.text=text;}
    public void setTime(String time){this.time =time;}
    public void setGoalTime(String goalTime){this.goalTime=goalTime;}


}
