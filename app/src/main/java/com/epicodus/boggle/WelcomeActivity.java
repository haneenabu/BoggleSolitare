package com.epicodus.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {
     @Bind(R.id.baseGridView)GridView mBaseGridView;
//     @Bind(R.id.grid_item_letter) TextView mGridLetterItem;

    String [] consonants = new String[]{
             "B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Z"
    };

    String [] vowels = new String[]{
            "A", "E", "I", "O", "U", "Y"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        ArrayList<String> finalLetters = new ArrayList<String>();


        mBaseGridView.setAdapter(new letterAdapter(this, finalLetters));



            for (int i = 0; i < 2; i++) {
                int randomIndex = new Random().nextInt(vowels.length);
                finalLetters.add(vowels[randomIndex]);
            }
            for (int i = 0; i < 6; i++) {
                int randomConsonant = new Random().nextInt(consonants.length);
                finalLetters.add(consonants[randomConsonant]);
            }

    }

}
