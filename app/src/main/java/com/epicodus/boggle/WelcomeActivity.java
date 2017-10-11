package com.epicodus.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.epicodus.boggle.R.styleable.View;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
     @Bind(R.id.baseGridView)GridView mBaseGridView;
     @Bind(R.id.check_word) EditText mCheckWord;
     @Bind(R.id.button) Button mButton;



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
    @Override
    public void onClick(View v){
        String WordChecker = mCheckWord.getText().toString();
        if(v == mButton){
            if(WordChecker.length() > 3){
                Toast toast = Toast.makeText(this, "This is a word", Toast.LENGTH_LONG );
                toast.show();
                mCheckWord.setText("");
            } else {
                Toast toast1 = Toast.makeText(this, "That is not a word", Toast.LENGTH_LONG);
                toast1.show();
            }
        }
    }

}
