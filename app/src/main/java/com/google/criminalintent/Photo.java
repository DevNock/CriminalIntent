package com.google.criminalintent;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Sergey on 18.01.2016.
 */
public class Photo {
    private static final String JSON_FILENAME = "fileName";

    private String fileName;

    public Photo(String fileName){
        this.fileName = fileName;
    }

    public Photo(JSONObject json) throws JSONException {
        fileName = json.getString(JSON_FILENAME);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(JSON_FILENAME, fileName);
        return jsonObject;
    }

    public String getFileName(){
        return fileName;
    }
}
