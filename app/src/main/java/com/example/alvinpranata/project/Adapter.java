package com.example.alvinpranata.project;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by AlvinPranata on 06/06/2017.
 */

public class Adapter extends FragmentPagerAdapter{
    private final ArrayList<Fragment> fragmentList = new ArrayList<>();

    public Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);

    }

    @Override
    public int getCount() {
        return fragmentList.size();

    }
    public void addFragment(Fragment f) {
        fragmentList.add(f);
    }

}
