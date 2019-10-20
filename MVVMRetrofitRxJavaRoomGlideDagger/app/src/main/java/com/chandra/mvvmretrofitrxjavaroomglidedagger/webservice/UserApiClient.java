package com.chandra.mvvmretrofitrxjavaroomglidedagger.webservice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.model.User;

import java.util.List;

public  class UserApiClient {
    private static final String TAG = "UserApiClient";
    private static UserApiClient mUserApiClientInstance;
//    private abstract UserApi userApi;
    private MutableLiveData<List<User>> mUser = new MutableLiveData<>();


    public UserApiClient() {

    }

    public synchronized static UserApiClient getmUserApiClientInstance() {
        if(mUserApiClientInstance == null){
            mUserApiClientInstance = new UserApiClient();

        }
        return mUserApiClientInstance;
    }

    public LiveData<List<User>> getmUser() {
//        mUser = ServiceGenrator.getUserApi().getUserList();


        return  mUser;
    }
}
