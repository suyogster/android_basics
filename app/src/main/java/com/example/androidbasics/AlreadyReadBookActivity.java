package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class AlreadyReadBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_book);

        RecyclerView recyclerView = findViewById(R.id.bookRecyclerView);
        BookRecyclerViewAdapter bookRecyclerViewAdapter = new BookRecyclerViewAdapter(this);
        recyclerView.setAdapter(bookRecyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        bookRecyclerViewAdapter.setBooks(Utils.getInstance(this).getAlreadyReadBooks());
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, BookActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}