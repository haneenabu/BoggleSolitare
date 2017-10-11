package com.epicodus.boggle;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;



public class letterAdapter extends BaseAdapter {
    private Context mContext;
//    private String[] mLetters;
    private ArrayList<String> mFinalLetters;




    public letterAdapter(Context context, ArrayList<String> finalLetters){
        this.mContext = context;

        this.mFinalLetters = finalLetters;
    }

    @Override
    public int getCount(){
        return 8;

    }
    @Override
    public Object getItem(int position){
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
        if (convertView == null) {
            // get layout from xml file
            gridView = inflater.inflate(R.layout.letter_grid_item, null);


            // pull views
            TextView letterView = (TextView) gridView
                    .findViewById(R.id.grid_item_letter);

            // set values into views
            letterView.setText(mFinalLetters.get(position));

        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }
}