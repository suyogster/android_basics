package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

public class CardViewSpinner extends AppCompatActivity {

    private Spinner nameSpinner;
    private ConstraintLayout parent;
    private ImageView cardImage;
    public Button cardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_spinner);

        nameSpinner = findViewById(R.id.nameSpinner);
        parent = findViewById(R.id.cardViewSpinnerLayout);
        cardImage = findViewById(R.id.imageView2);
        cardButton = findViewById(R.id.cardButton);


        nameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(parent, nameSpinner.getSelectedItem().toString() + " selected",Snackbar.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Snackbar.make(parent, nameSpinner.getSelectedItem().toString(),Snackbar.LENGTH_LONG).show();
            }
        });

        cardButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Boolean flag = false;
                flag = changeImage();
                if(flag == true){
                    cardImage.setImageResource(R.drawable.ic_add);
                }

            }
        });
    }

    public boolean changeImage(){
        return true;
    }

}