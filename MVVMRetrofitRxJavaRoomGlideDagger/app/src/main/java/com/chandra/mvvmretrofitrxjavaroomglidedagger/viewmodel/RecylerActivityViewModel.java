package com.chandra.mvvmretrofitrxjavaroomglidedagger.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.model.User;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.repository.Repository;

import java.util.List;

public class RecylerActivityViewModel extends ViewModel {

    private static final String TAG = "ReccylerActivityViewMod";
    private Repository mRepository;


    public RecylerActivityViewModel() {
        mRepository = Repository.getRepositoryInstance();
    }

    public LiveData<List<User>> getUserList() {
        return mRepository.getUserList();
    }


}
