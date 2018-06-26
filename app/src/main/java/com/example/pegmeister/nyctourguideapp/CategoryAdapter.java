package com.example.pegmeister.nyctourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTitle[] = new String[]{"Landmark", "Mustsee", "Dining", "Shopping"};
    private Context context;

    /**
     * create a new {@link CategoryAdapter} object.
     *
     * @param fm is a fragment manager that will keep each fragment's state in the adapter
     *           across swipes
     */

    public CategoryAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    /**
     * return the {@link Fragment} that should  be displayed for the given page number
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LandmarkFragment();
        } else if (position == 1) {
            return new MustSeeFragment();
        } else if (position == 2) {
            return new DiningFragment();
        } else {
            return new ShoppingFragment();
        }
    }

    /**
     * return total number of pages
     */
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // generate title based on item position
        return tabTitle[position];
    }
}



