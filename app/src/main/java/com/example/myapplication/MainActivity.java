package com.example.myapplication;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;
import androidx.transition.FragmentTransitionSupport;

import android.os.Bundle;
import android.widget.Toast;


import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemDatabase itemDatabase = Room.databaseBuilder(getApplicationContext(), ItemDatabase.class, "items")
                .createFromAsset("database/myapp.db")
                .build();


        FirebaseDatabase database = FirebaseDatabase.getInstance();

        TabLayout tabLayout = findViewById(R.id.mainTabLayout);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_chat_24));// chat
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_text_snippet_24)); // news
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_format_list_numbered_24)); // to do
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_info_24)); // info
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_settings_24)); // settings

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        Fragment firstFragment = new ChatFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, firstFragment).addToBackStack(null).commit();


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new ChatFragment();
                        break;
                    case 1:
                        fragment = new NewsFragment();
                        break;
                    case 2:
                        fragment = new ToDoFragment();
                        break;
                    case 3:
                        fragment = new InfoFragment();
                        break;
                    case 4:
                        fragment = new SettingsFragment();
                        break;
                }


                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.mainFrameLayout,  fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    @Override
    protected void onPause() {
        super.onPause();
        //SharedPreferences.Editor preferencesEditor = myPreferences.edit();

        // preferencesEditor.putInt(percentage, percent);
        // preferencesEditor.putInt(used, logins); better in restart
        // set country preference
        // preferencesEditor.apply();
    }


}