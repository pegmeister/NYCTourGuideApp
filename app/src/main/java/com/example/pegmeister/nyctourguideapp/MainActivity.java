package com.example.pegmeister.nyctourguideapp;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set activity content to use activity_main layout
        setContentView(R.layout.activity_main);

        // find the viewpager that will allow user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // set the adapter onto the viewpager
        viewPager.setAdapter(new CategoryAdapter(getSupportFragmentManager(), MainActivity.this));

        // find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // connect the tab layout with the viewpager
        tabLayout.setupWithViewPager(viewPager);
    }
}
