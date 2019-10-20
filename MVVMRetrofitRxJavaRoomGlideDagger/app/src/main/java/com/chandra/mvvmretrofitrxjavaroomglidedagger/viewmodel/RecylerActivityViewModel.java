package com.chandra.mvvmretrofitrxjavaroomglidedagger.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.adapter.model.User;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.repository.Repository;

import java.util.List;

public class RecylerActivityViewModel extends ViewModel {

    private static final String TAG = "ReccylerActivityViewMod";
    private Repository mRepository;


    public RecylerActivityViewModel() {
        mRepository = Repository.getRepositoryInstance();


    }

    public LiveData<List<User>> getUserList() {
        Log.d(TAG, "RecylerActivityViewModel: View Model called Constaructor"+mRepository);

        return mRepository.getUserList();
    }


}
