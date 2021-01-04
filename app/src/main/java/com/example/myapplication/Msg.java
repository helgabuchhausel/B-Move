package com.example.myapplication;

import android.net.Uri;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

class Msg {

        private String id;
        private String text;
        private String name;
        private String messageTime;

        public Msg(String text, String name) {
            this.text = text;
            this.name = name;

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm dd-MM-yyyy");
            Date time = new Date();
            this.messageTime = simpleDateFormat.format(time);
        }

    public Msg(String text, String name, String messageTime) {
        this.text = text;
        this.name = name;
        this.messageTime = messageTime;
    }


    public String getText(){ return text;}
    public void setText(String messageText) {
        this.text = messageText;
    }

    public String getName(){return name;}
    public void setName(String messageUser) {this.name = messageUser;}


    public String getMessageTime() {return messageTime;}
    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }


}
