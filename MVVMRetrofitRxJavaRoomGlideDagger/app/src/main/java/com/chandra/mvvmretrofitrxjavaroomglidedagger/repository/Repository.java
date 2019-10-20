package com.chandra.mvvmretrofitrxjavaroomglidedagger.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.model.User;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.webservice.ServiceGenrator;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.webservice.UserApiClient;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static final String TAG = "Repository";
    private static Repository mRepositoryInstance;
    private Application mAppContext;
    List<User> userList;
    private MutableLiveData<List<User>> mUserMutableLiveData = new MutableLiveData<>();

    private UserApiClient userApiClient;
//    private LiveData<List<User>> userListLiveData;

    private Repository() {
        userApiClient = UserApiClient.getmUserApiClientInstance();
    }


    // making this class as Singletoi
    public synchronized static Repository getRepositoryInstance() {
        if (null == mRepositoryInstance) {
            mRepositoryInstance = new Repository();
        }
        return mRepositoryInstance;
    }

    public LiveData<List<User>> getUserList() {
//        initUserList();
//        mUserMutableLiveData.setValue(userList);
//
//        return mUserMutableLiveData;
        return ServiceGenrator.getUsers();


    }

    private void initUserList() {

        Log.d(TAG, "initUserList: initUserList Called");
        userList = new ArrayList<>();
        User user = new User();
        user.setLogin("chandra");
        userList.add(user);
        User user1 = new User();
        user1.setLogin("Krishna");
        userList.add(user1);
        User user2 = new User();
        user2.setLogin("Jinal");
        userList.add(user2);
        User user3 = new User();
        user3.setLogin("Minakshi");
        userList.add(user3);

    }


}
