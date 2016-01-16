package com.google.criminalintent;

import android.graphics.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Sergey on 16.01.2016.
 */
public class CrimeCameraFragment extends Fragment {
    private static final String TAG = "CrimeCameraFragmet";

    private Camera camera;
    private SurfaceView surfaceView;
    private Button takePictureButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crime_camera, container, false);

        takePictureButton = (Button) view.findViewById(R.id.crime_camera_takePictureButtton);
        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        surfaceView = (SurfaceView) view.findViewById(R.id.crime_camera_surface);
        return view;
    }


}
