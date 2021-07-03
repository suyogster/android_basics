package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class RecyclerView extends AppCompatActivity {

    private androidx.recyclerview.widget.RecyclerView contactsRecView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        contactsRecView = findViewById(R.id.recyclerView);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Naruto","naruto@naruto.com","https://i.pinimg.com/originals/2a/92/06/2a9206a4a0d1d23cf92636c42115d054.jpg"));
        contacts.add(new Contact("Zaraki","zaraki@bleach.com","https://static.wikia.nocookie.net/bleach/images/8/8d/572Kenpachi_profile.png/revision/latest?cb=20210417222326&path-prefix=en"));
        contacts.add(new Contact("Luffy","luffy@onepiece.com","https://static.wikia.nocookie.net/onepiece/images/6/6d/Monkey_D._Luffy_Anime_Post_Timeskip_Infobox.png/revision/latest?cb=20200429191518"));
        contacts.add(new Contact("Eren","eren@aot.com","https://img.republicworld.com/republic-prod/stories/promolarge/xhdpi/fvtmt2ftcdwprlxz_1615273483.jpeg"));
        contacts.add(new Contact("Natsu","natsu@fairytale.com","https://static.wikia.nocookie.net/fairytail/images/c/ca/Natsu_X792.png/revision/latest?cb=20181111122101"));
        contacts.add(new Contact("Elric","elric@alchemist.com","https://static.wikia.nocookie.net/fma/images/0/08/213254_1407532169190_full.png/revision/latest?cb=20201016012253"));
        contacts.add(new Contact("Aang","aang@avatar.com","https://static3.srcdn.com/wordpress/wp-content/uploads/2020/06/Avatar-The-Last-Airbender-Old-Aang.jpg?q=50&fit=crop&w=960&h=500&dpr=1.5"));
        contacts.add(new Contact("Sokka","sokka@avatar.com","https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/sokka-avatar-the-last-airbender-1590006889.png?resize=480:*"));

        ContactRecViewAdapter contactRecViewAdapter = new ContactRecViewAdapter(this);

        contactRecViewAdapter.setContacts(contacts);

        contactsRecView.setAdapter(contactRecViewAdapter);

        // programatically managed layout
        contactsRecView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}