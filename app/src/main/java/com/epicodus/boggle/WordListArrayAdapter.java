package com.epicodus.boggle;


import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class WordListArrayAdapter extends ArrayAdapter{
    private Context context;
    private ArrayList<String> mWordList;

    public WordListArrayAdapter(Context context, int resource, ArrayList<String> mWordList){
        super(context, resource);
        this.mWordList = mWordList;
    }
    @Override
    public Object getItem(int position){
        String word = mWordList.get(position);
        return String.format("%s \n", word);
    }
    @Override
    public int getCount(){
        return mWordList.size();
    }
}