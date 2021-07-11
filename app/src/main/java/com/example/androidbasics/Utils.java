package com.example.androidbasics;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static final String ALL_BOOK_KEY = "books";
    private static final String ALL_READY_READ_BOOKS = "already_read_books";
    private static final String CURRENTLY_READING_BOOKS = "currently_reading_books";

    private static Utils instance;

    private SharedPreferences sharedPreferences;


// Previously we used ArrayList -> migrated to alternate db
//    private static ArrayList<Book> books;
//    private static ArrayList<Book> alreadyReadBooks;
//    private static ArrayList<Book> currentlyReading;

    public ArrayList<Book> getBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOK_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_READY_READ_BOOKS, null), type);
        return books;
    }

    public ArrayList<Book> getCurrentlyReading() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS, null), type);
        return books;
    }

    /**
     * Constructor of Utils class
     * Shared Preference initialization
     * Initialize Data if book db is empty
     * if db is empty, give an empty array of book
     * @param context
     */
    public Utils(Context context) {

        // MODE PRIVATE SPECIFIC TO THIS APP
        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);

        if(null == getBooks()) {
            initData();
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        if(null == getAlreadyReadBooks()) {
            editor.putString(ALL_READY_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }

        if(null == getCurrentlyReading()){
            editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
    }

    /**
     * Intial Data into Shared Preference from a static Array list
     */
    private void initData() {
        // TODO : add Initial Data
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "180",
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSuJ_yewMdULCJT15hAwyU-OikRIU0GC6yPuUyaBcEk08yEMc5E",
                " A Novel by F. Scott Fitzgerald",
                "The Great Gatsby, F. Scott Fitzgerald’s third book, stands as the supreme achievement of his career." +
                        " First published in 1925, this quintessential novel of the Jazz Age has been acclaimed by generations of readers."
        ));

        books.add(new Book(2, "The Kite Runner", "Khaled Hosseini","371",
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSbz4BZeSQhv_E9kYEpkOyqctf9Yqx4ys9LtSjoEbblyTRW1DKI",
                "The Kite Runner is the first novel by Afghan-American author Khaled Hosseini.",
                "The Kite Runner is a moving story of an unlikely friendship between a wealthy boy and the son of his father’s servant. Set in Afghanistan during a time of tragedy and destruction, this unforgettable novel will have you hooked from start to finish."
        ));

        books.add(new Book(3, "Philosopher’s Stone", "J.K. Rowling","223",
                "https://static.wikia.nocookie.net/harrypotter/images/7/7a/Harry_Potter_and_the_Philosopher%27s_Stone_–_Bloomsbury_2014_Children%27s_Edition_%28Paperback_and_Hardcover%29.jpg/revision/latest?cb=20170109041611",
                "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts. Even as he escapes a dreary life and enters a world of magic, he finds trouble awaiting him.",
                "This global bestseller took the world by storm. So, if you haven’t read J.K. Rowling’s Harry Potter, now may be the time. Join Harry Potter and his schoolmates as this must-read book transports you deep into a world of magic and monsters."
        ));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOK_KEY, gson.toJson(books));
        editor.commit();

    }

    public static synchronized Utils getInstance(Context context){
        // logic to make the class singleton pattern
        if (null == instance) {
            instance = new Utils(context);
        }
        return instance;
    }

    /**
     *
     * @param id
     * @return
     */
    public Book getBookById(int id){
        ArrayList<Book> books = getBooks();
        if(null != books){
            for (Book b: books){
                if(b.getId() == id){
                    return b;
                }
            }
        }
        return null;
    }

    public boolean addToAlreadyReadBooks(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALL_READY_READ_BOOKS);
                editor.putString(ALL_READY_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToCurrentlyReadingBooks(Book book) {
        ArrayList<Book> books = getCurrentlyReading();
        if(null != books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS);
                editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean removeFromAlreadyReadBooks(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if(null != books){
            for(Book b: books){
                if(b.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALL_READY_READ_BOOKS);
                        editor.putString(ALL_READY_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public boolean removeFromCurrentlyReading(Book book){
        ArrayList<Book> books = getCurrentlyReading();
        if(null != books){
            for(Book b: books){
                if(b.getId() == book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS);
                        editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }

        }
        return false;
    }

}
