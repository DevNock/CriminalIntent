package com.google.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Sergey on 16.01.2016.
 */
public class CrimeCameraActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeCameraFragment();
    }
}
