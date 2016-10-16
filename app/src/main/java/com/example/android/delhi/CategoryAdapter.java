package com.example.android.delhi;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by trikh on 11-10-2016.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MonumentFragment();
            case 1:
                return new MuseumFragment();
            case 2:
                return new LibraryFragment();
            case 3:
                return new ParkFragment();
            default:
                Log.v("Category", "Category NotFound");
                return null;

        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.monuments);
            case 1:
                return mContext.getString(R.string.museums);
            case 2:
                return mContext.getString(R.string.libraries);
            case 3:
                return mContext.getString(R.string.parks);
            default:
                Log.v("Category", "Category name NotFound");
                return null;

        }
    }
}