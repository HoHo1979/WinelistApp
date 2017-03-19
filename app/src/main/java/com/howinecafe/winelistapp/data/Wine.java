package com.howinecafe.winelistapp.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by JamesHo on 3/19/2017.
 */

public class Wine implements Serializable {

    String _id;
    String name;
    int vintage;
    int score;
    Double price;
    String imageName;

    public Wine(String name, int vintage, int score, Double price, String imageName) {
        this.name = name;
        this.vintage = vintage;
        this.score = score;
        this.price = price;
        this.imageName = imageName;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVintage() {
        return vintage;
    }

    public void setVintage(int vintage) {
        this.vintage = vintage;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }



}
