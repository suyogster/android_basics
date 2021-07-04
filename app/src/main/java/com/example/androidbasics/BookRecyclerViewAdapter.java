package com.example.androidbasics;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "BookRecyclerViewAdapter";

    private ArrayList<Book> books = new ArrayList<>();
    private Context context;

    public BookRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.textName.setText(books.get(position).getName());
        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.imageBook);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, books.get(position).getName() + " Selected", Toast.LENGTH_LONG).show();
            }
        });
        // 0 -> position of array
        // isExpanded() -> true
        // !isExpanded() -> false
//        if(books.get(position).isExpanded()){
//            holder.expandedRelLayout.setVisibility(View.VISIBLE);
//            holder.downArrow.setVisibility(View.GONE);
//        }else {
//
//        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView parent;
        private ImageView imageBook;
        private TextView textName;

        private ImageView downArrow, upArrow;
        private RelativeLayout expandedRelLayout;
        private TextView textAuthor, textShortDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.bookCardViewParent);
            imageBook = itemView.findViewById(R.id.imgBook);
            textName = itemView.findViewById(R.id.textBookName);

            downArrow = itemView.findViewById(R.id.expandCardButton);
            upArrow = itemView.findViewById(R.id.collapsedCardLayout);
            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);
            textAuthor = itemView.findViewById(R.id.authorTextValue);
            textShortDescription = itemView.findViewById(R.id.textShortDescriptionValue);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });



        }
    }
}
