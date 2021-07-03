package com.example.androidbasics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ContactRecViewAdapter extends RecyclerView.Adapter<ContactRecViewAdapter.ViewHolder> {


    private ArrayList<Contact> contacts = new ArrayList<>();

    public  Context context;

    public ContactRecViewAdapter(Context context){
    this.context = context;
    }

    @NonNull
    @Override
    //Create an instance of view holder class in every item in our recycler view
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    //View holder argument
    //position => index of the item in the array
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.contactName.setText(contacts.get(position).getName());
        holder.contactEmail.setText((contacts.get(position).getEmail()));

        // to set onClickListener to the card view itself
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(context, v, contacts.get(position).getName() + " Selected", Snackbar.LENGTH_LONG).show();
            }
        });

        // to render image URLs
        Glide.with(context)
                .asBitmap().load(contacts.get(position).getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    //inner class
    //responsible for holding the view items for evey item
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView contactName, contactEmail;
        private CardView parent;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            contactName = itemView.findViewById(R.id.contactName);
            contactEmail = itemView.findViewById(R.id.contactEmail);
            parent = itemView.findViewById(R.id.contactListParent);
            imageView = itemView.findViewById(R.id.recyclerViewImage);
        }

    }
}
