package com.fanhl.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by fanhl on 2017/2/15.
 */
public class MyAdapter extends FragmentStatePagerAdapter {
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override public Fragment getItem(int position) {
        return MyFragment.newInstance();
    }

    @Override public int getCount() {
        return 10;
    }
}
