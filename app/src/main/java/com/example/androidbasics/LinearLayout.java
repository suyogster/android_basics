package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LinearLayout extends AppCompatActivity {

    private TextView linearTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String statePassedFromMainActivity = extras.getString("destination");
            System.out.println("debug " + statePassedFromMainActivity);
            linearTextView = findViewById(R.id.linearTextView);
            linearTextView.setText(statePassedFromMainActivity);
        }

    }
}