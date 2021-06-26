package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class RelativeLayout extends AppCompatActivity {

    private View parent;
    private TextView text;
    private TextInputEditText inputField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        parent = findViewById(R.id.relativeLayoutParent);
        text = findViewById(R.id.firstTextView);
        inputField = findViewById(R.id.inputEditTextBox);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable inputText = inputField.getText();
                text.setText(inputText);
                Snackbar.make(parent, inputText + " has been displayed", Snackbar.LENGTH_LONG)
                        .setAction("Again", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(RelativeLayout.this, inputText + " has been displayed", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setActionTextColor(Color.RED)
                        .setTextColor(Color.YELLOW).show();
            }
        });

    }
}