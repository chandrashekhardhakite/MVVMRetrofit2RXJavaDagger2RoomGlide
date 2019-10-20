package com.chandra.mvvmretrofitrxjavaroomglidedagger.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.model.User;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.repository.Repository;

import java.util.List;

public class RecylerActivityViewModel extends AndroidViewModel {

    private static final String TAG = "ReccylerActivityViewMod";
    private Repository mRepository;

    public RecylerActivityViewModel(@NonNull Application application ){
        super(application);
        mRepository = Repository.getRepositoryInstance(application);
    }


    public LiveData<List<User>> getUserList() {
        return mRepository.getUserList();
    }


}
