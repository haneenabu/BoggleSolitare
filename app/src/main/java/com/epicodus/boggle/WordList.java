package com.epicodus.boggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.epicodus.boggle.R.mipmap.boggle;

public class WordList extends AppCompatActivity {

    @Bind(R.id.wordListView) ListView mWordListView;
    @Bind(R.id.wordTextView) TextView mWordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        ArrayList<String> wordList = intent.getStringArrayListExtra("wordList");

        System.out.println(wordList);

        WorldListArrayAdapter adapter = new WordListArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                wordList);

    }
}
