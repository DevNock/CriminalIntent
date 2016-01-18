package com.google.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Sergey on 16.01.2016.
 */
public class CrimeCameraActivity extends SingleFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.CameraTheme);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);       // Hide action panel and other OC view
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment createFragment() {
        return new CrimeCameraFragment();
    }
}
