package com.example.pegmeister.nyctourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context context;

    /**
     * create a new {@link CategoryAdapter} object.
     *
     * @param fragmentManager is a fragment manager that will keep each fragment's state in the adapter
     *           across swipes
     */

    public CategoryAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
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
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // generate title based on item position
        switch (position) {
            case 0:
                return context.getString(R.string.category_landmark);
            case 1:
                return context.getString(R.string.category_mustsee);
            case 2:
                return context.getString(R.string.category_dine);
            case 3:
                return context.getString(R.string.category_shop);
            default:
                return null;
        }
    }
}



