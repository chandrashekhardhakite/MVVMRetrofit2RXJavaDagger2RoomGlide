package com.chandra.mvvmretrofitrxjavaroomglidedagger.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.R;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.adapter.model.User;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.ui.RecyclerActivity;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "RecyclerActivityAdapter";
    List<User> userList;

    public RecyclerActivityAdapter(List<User> list){
            this.userList = list;
    }

    public void updateUserList(List<User> list){
        this.userList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((RecyclerViewHolder)holder).textViewTitle.setText(userList.get(position).getLogin());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
