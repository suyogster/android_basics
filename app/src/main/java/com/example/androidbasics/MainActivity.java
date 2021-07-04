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
        Button cardViewSpinner = findViewById(R.id.cardViewSpinnerButton);
        Button recyclerView = findViewById(R.id.recyclerViewButton);
        Button navigation = findViewById(R.id.navigationButton);
        Button booksRecyclerView = findViewById(R.id.bookRecyclerViewButton);


        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linearIntent = new Intent(MainActivity.this,LinearLayout.class);
                linearIntent.putExtra("destination", "Linear Layout Passed from Intent");
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

        cardViewSpinner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CardViewSpinner.class);
                startActivity(intent);
            }
        });

        recyclerView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerView.class);
                startActivity(intent);
            }
        });

        navigation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NavigationHost.class);
                startActivity(intent);
            }
        });

        booksRecyclerView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookActivity.class);
                startActivity(intent);
            }
        });

    }


}