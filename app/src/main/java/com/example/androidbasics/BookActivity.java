package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private RecyclerView booksRecView;
    private BookRecyclerViewAdapter bookRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        bookRecyclerViewAdapter = new BookRecyclerViewAdapter(this);
        booksRecView = findViewById(R.id.booksRecView);

        booksRecView.setAdapter(bookRecyclerViewAdapter);
        booksRecView.setLayoutManager(new GridLayoutManager(this, 2));


        bookRecyclerViewAdapter.setBooks(Utils.getInstance(this).getBooks());
    }
}