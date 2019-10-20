package com.chandra.mvvmretrofitrxjavaroomglidedagger.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.R;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.model.User;

import java.util.List;

public class RecyclerActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "RecyclerActivityAdapter";
    List<User> userList;

    public RecyclerActivityAdapter(List<User> list) {
        this.userList = list;
    }

    public void updateUserList(List<User> list) {
        this.userList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((RecyclerViewHolder) holder).textViewTitle.setText(userList.get(position).getLogin());

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(holder.itemView.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(userList.get(position).getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(((RecyclerViewHolder) holder).imageViewProfile);
    }

    @Override
    public int getItemCount() {
        if (userList != null)
            return userList.size();
        else return 0;
    }
}
