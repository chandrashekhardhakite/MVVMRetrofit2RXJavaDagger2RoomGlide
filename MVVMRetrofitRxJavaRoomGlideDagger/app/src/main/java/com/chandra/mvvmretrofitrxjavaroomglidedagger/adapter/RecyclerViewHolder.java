package com.chandra.mvvmretrofitrxjavaroomglidedagger.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView imageViewProfile;
    public TextView textViewTitle;


    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewProfile = itemView.findViewById(R.id.imageView);
        textViewTitle = itemView.findViewById(R.id.textView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }


}