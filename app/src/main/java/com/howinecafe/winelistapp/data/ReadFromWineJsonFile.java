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
            values.put(WineContract.NAME,winejsonObject.getString(WineContract.NAME));
            values.put(WineContract.VINTAGE,winejsonObject.getString(WineContract.VINTAGE));
            values.put(WineContract.SCORE,winejsonObject.getInt(WineContract.SCORE));
            values.put(WineContract.PRICE,winejsonObject.getInt(WineContract.PRICE));

            Log.i(TAG,values.get(WineContract.NAME).toString()+values.getAsInteger(WineContract.SCORE));


        }




    }
}
