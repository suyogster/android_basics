package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailBookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private TextView bookName, authorName, pageCount, shortDesc, longDesc;
    private ImageView bookImage;
    private Button currentlyReading, finishedReading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);
        initView();

        Intent intent = getIntent();
        if (null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if(bookId != -1){
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                if(null != incomingBook){
                    setData(incomingBook);
                    handleAlreadyRead(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                }
            }
        }
    }

    private void handleCurrentlyReadingBooks(Book book){
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance(this).getCurrentlyReading();

        // flag to identify if the current book id is already in db or not
        boolean existsCurrentlyReading = false;
        for (Book b: currentlyReadingBooks){
            if(b.getId() == book.getId()){
                existsCurrentlyReading = true;
            }
        }
        if(existsCurrentlyReading){
            currentlyReading.setEnabled(false);
        }else {
            currentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(DetailBookActivity.this).addToCurrentlyReadingBooks(book)){
                        Toast.makeText(DetailBookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        // TODO: Navigate the user
                        Intent intent = new Intent(DetailBookActivity.this, CurrentlyReadingBooks.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(DetailBookActivity.this, "Error! Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleAlreadyRead(Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyReadBooks();
        boolean existsInAlreadyRead = false;
        for (Book b: alreadyReadBooks){
            if(b.getId() == book.getId())
            {
                existsInAlreadyRead = true;
            }
        }
        if(existsInAlreadyRead){
            finishedReading.setEnabled(false);
        }else {
            finishedReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(DetailBookActivity.this).addToAlreadyReadBooks(book)){
                        Toast.makeText(DetailBookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        // TODO: Navigate the user
                        Intent intent = new Intent(DetailBookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(DetailBookActivity.this, "Error! Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
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