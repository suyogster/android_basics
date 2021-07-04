package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailBookActivity extends AppCompatActivity {

    private TextView bookName, authorName, pageCount, shortDesc, longDesc;
    private ImageView bookImage;
    private Button currentlyReading, finishedReading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);
        initView();

        Book book = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "180",
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSuJ_yewMdULCJT15hAwyU-OikRIU0GC6yPuUyaBcEk08yEMc5E",
                " A Novel by F. Scott Fitzgerald",
                "The Great Gatsby, F. Scott Fitzgerald’s third book, stands as the supreme achievement of his career." +
                        " First published in 1925, this quintessential novel of the Jazz Age has been acclaimed by generations of readers."
                        );
        setData(book);

    }

    private void setData(Book book){
        bookName.setText(book.getName());
        authorName.setText(book.getAuthor());
        pageCount.setText(book.getPages());
        shortDesc.setText(book.getShortDesc());
        longDesc.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap()
                .load(book.getImageUrl())
                .into(bookImage);
    }

    public void initView(){
        bookName = findViewById(R.id.bookName);
        authorName = findViewById(R.id.authorName);
        pageCount = findViewById(R.id.pageCount);
        shortDesc = findViewById(R.id.shortDesc);
        longDesc = findViewById(R.id.longDesc);

        bookImage = findViewById(R.id.bookImageView);

        currentlyReading = findViewById(R.id.currentlyReadingButton);
        finishedReading = findViewById(R.id.finishedReading);
    }
}