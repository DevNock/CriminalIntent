package com.google.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Sergey on 30.11.2015.
 */
public class CrimeLab {
    private ArrayList<Crime> crimes;

    private static CrimeLab crimeLab;
    private Context appContext;

    private CrimeLab(Context appContext){
        this.appContext = appContext;
        crimes = new ArrayList<>();
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

    public void addCrime(Crime crime){
        crimes.add(crime);
    }
}
