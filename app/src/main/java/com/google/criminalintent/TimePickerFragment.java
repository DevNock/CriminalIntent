package com.google.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by Sergey on 18.12.2015.
 */
public class TimePickerFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_time, null);


        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.time_picker_title)
                .setView(view)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }

    public static TimePickerFragment newInstance(){
        TimePickerFragment fragment = new TimePickerFragment();
        return fragment;
    }
}