package com.example.abhik.mbti;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {


    public static final String TAG="Adptr";
    private int fragCount = 0;

    public SectionsPagerAdapter(FragmentManager fm, int count) {
        super(fm);
        this.fragCount = count;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        Fragment fragment = new PlaceholderFragment();


        Bundle args = new Bundle();
        args.putInt("page_position",position+1);

        PlaceholderFragment.newInstance(position+1).setArguments(args);
        Log.d(TAG, "getItem: "+PlaceholderFragment.newInstance(position+1));
        return PlaceholderFragment.newInstance(position + 1);
//        return  fragment;


    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return fragCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
        }
        return null;
    }
}
