package com.howinecafe.winelistapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.nfc.Tag;
import android.util.Log;

import com.howinecafe.winelistapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JamesHo on 3/19/2017.
 */

public class ReadFromWineJsonFile {

    private static final String TAG=ReadFromWineJsonFile.class.getSimpleName();

    List<Wine> wineList = new ArrayList<>();
    FileInputStream fileInputStream;
    private final Resources resources;


    public ReadFromWineJsonFile(Context context) throws IOException, JSONException {

        resources = context.getResources();
        StringBuilder builder = new StringBuilder();
        InputStream inputStream = resources.openRawResource(R.raw.wineinfo);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while((line=reader.readLine())!=null){
            builder.append(line);
        }

        JSONObject root = new JSONObject(builder.toString());
        JSONArray wines = root.getJSONArray(WineContract.WINELISTS);

        for(int i=0;i<wines.length();i++){

            JSONObject winejsonObject=wines.getJSONObject(i);
            ContentValues values = new ContentValues();

            String name = winejsonObject.getString(WineContract.NAME);
            int vintage = winejsonObject.getInt(WineContract.VINTAGE);
            int score=winejsonObject.getInt(WineContract.SCORE);
            Double price=winejsonObject.getDouble(WineContract.PRICE);
            String imageName = winejsonObject.getString(WineContract.IMAGENAME);
            values.put(WineContract.NAME,name);
            values.put(WineContract.VINTAGE,vintage);
            values.put(WineContract.SCORE,score);
            values.put(WineContract.PRICE,price);
            values.put(WineContract.IMAGENAME,imageName);

            Wine wine = new Wine(name,vintage,score,price,imageName);
            wineList.add(wine);

        }

    }

    public List<Wine> getWineList() {
        return wineList;
    }
}
