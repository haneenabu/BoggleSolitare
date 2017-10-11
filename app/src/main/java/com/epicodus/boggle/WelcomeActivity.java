package com.epicodus.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.epicodus.boggle.R.styleable.View;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
     @Bind(R.id.baseGridView)GridView mBaseGridView;
     @Bind(R.id.check_word) EditText mCheckWord;
     @Bind(R.id.button) Button mButton;

     ArrayList<String> finalLetters = new ArrayList<String>();


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
        mButton.setOnClickListener(this);




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
    @Override
    public void onClick(View v){
        String inputWord = mCheckWord.getText().toString();
        int userPoints =0;
        ArrayList finalLettersCopy = finalLetters;

        if(v == mButton){

            if(inputWord.length() > 3){
                for(int t=0; t < inputWord.length(); t++){
                    if (finalLettersCopy.contains(String.valueOf(inputWord.charAt(t)))) {
                        userPoints ++;
                        finalLettersCopy.remove(String.valueOf(inputWord.charAt(t)));
                    } else{
                        break;

                    }
                }

                if (userPoints == inputWord.length()){
                    Toast winToast = Toast.makeText(this, "This is a word", Toast.LENGTH_LONG );
                    winToast.show();
                } else{
                    Toast noMatch = Toast.makeText(this, "Not all the letters in the word match", Toast.LENGTH_LONG );
                    noMatch.show();
                }

            }
            else{
                Toast toast1 = Toast.makeText(this, "That is not a word", Toast.LENGTH_LONG);
                toast1.show();
            }

                mCheckWord.setText("");
            }
        }
    }


