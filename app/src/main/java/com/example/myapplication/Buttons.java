package com.example.myapplication;

import androidx.fragment.app.Fragment;

class Buttons {
    private String name;
    private Fragment fragment;

    Buttons(String name, Fragment fragment){
        this.name = name;
        this.fragment = fragment;
    }

    public String getName() { return name; }
    public Fragment getFragment() { return fragment; }
}
