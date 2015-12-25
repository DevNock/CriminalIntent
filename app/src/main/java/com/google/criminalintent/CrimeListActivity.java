package com.google.criminalintent;


import android.support.v4.app.Fragment;

/**
 * Created by Sergey on 30.11.2015.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
