package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button linearLayout = findViewById(R.id.linearLayoutButton);
        Button relativeLayout = findViewById(R.id.relativeLayoutButton);
        Button listView = findViewById(R.id.listViewButton);


        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linearIntent = new Intent(MainActivity.this,LinearLayout.class);
                startActivity(linearIntent);
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RelativeLayout.class);
                startActivity(intent);
            }
        });

        listView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewExample.class);
                startActivity(intent);
            }
        });
    }


}