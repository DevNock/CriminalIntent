package com.google.criminalintent;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.IOException;
import java.util.List;

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
    @SuppressWarnings("deprecation")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crime_camera, container, false);

        takePictureButton = (Button) view.findViewById(R.id.crime_camera_takePictureButton);
        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });



        surfaceView = (SurfaceView) view.findViewById(R.id.crime_camera_surface);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS); // for devices < 3.0(before Honeycomb)
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                // Приказываем камере использовать указанную
                // поверхность как область предварительного просмотра
                try {
                    if (camera != null) {
                        camera.setPreviewDisplay(holder);
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Error setting up preview display", e);
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                if (camera == null) {
                    return;
                }
                Camera.Parameters parameters = camera.getParameters();
                Camera.Size size = getBestSupportedSize(parameters.getSupportedPreviewSizes(), width, height);
                parameters.setPreviewSize(size.width, size.height);
                camera.setParameters(parameters);
                try {
                    camera.startPreview();
                } catch (Exception e) {
                    Log.e(TAG, "Could not start preview", e);
                    camera.release();
                    camera = null;
                }
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if (camera != null) {
                    camera.stopPreview();
                }
            }
        });



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        camera = Camera.open(0);

    }

    @Override
    public void onPause() {
        super.onPause();
        if(camera != null){
            camera.release();
            camera = null;
        }
    }

    private Camera.Size getBestSupportedSize(List<Camera.Size> sizes, int width, int height){
        Camera.Size bestSize = sizes.get(0);
        int largestArea = bestSize.width * bestSize.height;
        for (Camera.Size s : sizes){
            int area = s.width * s.height;
            if(area > largestArea){
                bestSize = s;
                largestArea = area;
            }
        }
        return bestSize;
    }
}
