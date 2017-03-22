package com.howinecafe.winelistapp;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.howinecafe.winelistapp.data.Wine;
import com.howinecafe.winelistapp.data.WineContract;

import java.util.List;

/**
 * Created by JamesHo on 3/20/2017.
 */

public class WineRecyclerViewAdapter extends RecyclerView.Adapter {


    Cursor cursor=null;
    List<Wine> wineList;
    int image[]={R.drawable.lafite,R.drawable.margaux,R.drawable.latour,R.drawable.mouton,R.drawable.hautbrion};

    public WineRecyclerViewAdapter(List<Wine> wineList) {

        this.wineList=wineList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.wine_list,parent,false);
        WineViewHolder wineViewHolder = new WineViewHolder(view);
        return wineViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        Wine wine=wineList.get(position);

//        cursor.moveToPosition(position);
//
//        String name=cursor.getString(cursor.getColumnIndex(WineContract.NAME));
//        Integer vintage = cursor.getInt(cursor.getColumnIndex(WineContract.VINTAGE));
//        Integer score = cursor.getInt(cursor.getColumnIndex(WineContract.SCORE));
//        Double price = cursor.getDouble(cursor.getColumnIndex(WineContract.PRICE));


//        WineViewHolder wineViewHolder = (WineViewHolder) holder;
//        wineViewHolder.name.setText(name);
//        wineViewHolder.vintage.setText(String.valueOf(vintage));
//        wineViewHolder.score.setText(String.valueOf(score));
//        wineViewHolder.score.setText(String.valueOf(price));

        WineViewHolder wineViewHolder = (WineViewHolder) holder;
        wineViewHolder.name.setText(wine.getName());
        wineViewHolder.vintage.setText(String.valueOf(wine.getVintage()));
        wineViewHolder.score.setText(String.valueOf(wine.getScore()));
        wineViewHolder.price.setText(String.valueOf(wine.getPrice()));
        wineViewHolder.imageName.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {
        //return cursor.getCount();
        return wineList.size();
    }

    public static class WineViewHolder extends RecyclerView.ViewHolder{

        private final TextView name;
        private final TextView vintage;
        private final TextView score;
        private final TextView price;
        private final ImageView imageName;


        public WineViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            vintage = (TextView) itemView.findViewById(R.id.vintage);
            score = (TextView) itemView.findViewById(R.id.score);
            price = (TextView) itemView.findViewById(R.id.price);
            imageName= (ImageView) itemView.findViewById(R.id.imageView);

        }
    }



}
