package com.oroblesr.displayjokeslibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private String intentKey  = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(intentKey);

        TextView jokeTextView = (TextView) findViewById(R.id.jokeDisplayText);
        jokeTextView.setText(joke);
    }
}
