package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ListViewExample extends AppCompatActivity {


    private View parent;
    private ListView cities;
    private FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        parent = findViewById(R.id.listViewParent);

        cities = findViewById(R.id.country_listView);

        // Defined citiesList variable as a ArrayList and added three String element to it
        ArrayList<String> citiesList = new ArrayList<>();
        citiesList.add("Kathmandu");
        citiesList.add("Bhaktapur");
        citiesList.add("Lalitpur");

        // Defined a Adapter to set into List View with citiesList as Array<String>
        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                citiesList
        );
        cities.setAdapter(citiesAdapter);


        addButton = findViewById(R.id.floatingAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> citiesList = new ArrayList<>();
                citiesList.add("Chitwan");
                citiesList.add("Bharatpur");
                citiesList.add("Hetauda");

                ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(
                        ListViewExample.this,
                        android.R.layout.simple_list_item_1,
                        citiesList
                );
                cities.setAdapter(citiesAdapter);
                Snackbar.make(parent, "Array Clicked",Snackbar.LENGTH_SHORT).show();
            }
        });

    }
}