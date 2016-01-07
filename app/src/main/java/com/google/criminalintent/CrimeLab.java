package com.google.criminalintent;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Sergey on 30.11.2015.
 */
public class CrimeLab {
    private static final String TAG = "CrimeLab";
    private static final String FILENAME = "crimes.json";

    private ArrayList<Crime> crimes;
    private CriminalIntentJSONSerializer serializer;

    private static CrimeLab crimeLab;
    private Context appContext;

    private CrimeLab(Context appContext){
        this.appContext = appContext;
        serializer = new CriminalIntentJSONSerializer(appContext, FILENAME);

        try{
            crimes = serializer.loadCrimes();
        } catch(Exception e){
            crimes = new ArrayList<Crime>();
            Log.e(TAG, "Error loading crimes: ", e);
        }
    }

    public static CrimeLab get(Context c){
        if (crimeLab == null){
            crimeLab = new CrimeLab(c.getApplicationContext());
        }
        return crimeLab;
    }

    public ArrayList<Crime> getCrimes(){
        return crimes;
    }

    public Crime getCrime(UUID id){
        for (Crime c : crimes){
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }

    public boolean saveCrimes() {
        try {
            serializer.saveCrimes(crimes);
            Log.d(TAG, "crimes saved to file");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Error saving crimes: ", e);
            return false;
        }
    }

    public void addCrime(Crime crime){
        crimes.add(crime);
    }
}
