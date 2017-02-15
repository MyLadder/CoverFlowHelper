package com.fanhl.sample;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
    }

    private void assignViews() {
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);

        adapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}
