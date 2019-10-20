package com.chandra.mvvmretrofitrxjavaroomglidedagger.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.R;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.adapter.RecyclerActivityAdapter;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.adapter.model.User;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.viewmodel.RecylerActivityViewModel;

import java.util.List;


public class RecyclerActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerActivity";
    private RecyclerView mRecyclerView;
    private List<User> userList;
    private RecylerActivityViewModel mRecylerActivityViewModel;
    private RecyclerActivityAdapter mRecyclerActivityAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        mRecyclerView = findViewById(R.id.recyleview);
        mRecylerActivityViewModel = ViewModelProviders.of(this).get(RecylerActivityViewModel.class);
//        mRecylerActivityViewModel.
        intiRecyclerView();
        subsribeObserver();
    }

    private void subsribeObserver() {
        mRecylerActivityViewModel.getUserList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                mRecyclerActivityAdapter.updateUserList(users);
                mRecyclerActivityAdapter.notifyDataSetChanged();
            }
        });
    }


    private void intiRecyclerView() {
        mRecyclerActivityAdapter = new RecyclerActivityAdapter(userList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerActivityAdapter);
    }
}
