package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

class NewsPagerAdapter extends FragmentStatePagerAdapter {

    int numberOfTabs;

    public NewsPagerAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numberOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new BrusselsTimesFragment();
            case 1: return new CovidFragment();
            case 2: return new VrtFragment();
            case 3: return new EuroFragment();
            default: return null;

        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
