package com.epicodus.boggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WordList extends AppCompatActivity {

    @Bind(R.id.wordListView) ListView mWordListView;
    @Bind(R.id.wordTextView) TextView mWordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String wordList = intent.getStringExtra("wordList");
        mWordText.setText(wordList);
    }
}
