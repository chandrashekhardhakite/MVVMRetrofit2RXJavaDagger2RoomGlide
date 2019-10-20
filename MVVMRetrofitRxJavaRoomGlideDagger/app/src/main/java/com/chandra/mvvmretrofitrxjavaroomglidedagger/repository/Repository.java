package com.chandra.mvvmretrofitrxjavaroomglidedagger.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.db.RoomDatabaseApp;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.db.UserDao;
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
    private UserDao userDao;
    private RoomDatabaseApp mRoomDatabaseApp;
    private static LiveData<List<User>> mListLiveDataUsers;

    private Repository(Application application) {
        userApiClient = UserApiClient.getmUserApiClientInstance();
        if(application!=null)
        mRoomDatabaseApp = RoomDatabaseApp.getRoomDatabaseAppInstance(application);
        userDao = mRoomDatabaseApp.userDao();

    }


    // making this class as Singletoi
    public synchronized static Repository getRepositoryInstance(Application application) {
        if (null == mRepositoryInstance) {
            mRepositoryInstance = new Repository(application);
        }
        return mRepositoryInstance;
    }

    public LiveData<List<User>> getUserList() {
//        initUserList();
//        mUserMutableLiveData.setValue(userList);
//
//        return mUserMutableLiveData;
//        return ServiceGenrator.getUsers();


        // Need to write logic to retrive data from the database
        return getUserListFromDB();
    }


    public void insertUserInDB(User user){

    }

    public void deleteUserFromDB(User user){

    }

    public LiveData<List<User>> getUserListFromDB(){
//        new ReadUsersFromDBThroughAsynch(userDao).execute();
        return userDao.getUserList();
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


//    public static class ReadUsersFromDBThroughAsynch extends AsyncTask<Void, LiveData<List<User>> ,Void>{
//
//        private UserDao userDao;
//
//        public ReadUsersFromDBThroughAsynch(UserDao userDao) {
//            this.userDao = userDao;
//        }
//
//        @Override
//        protected  LiveData<List<User>>  doInBackground(Void... voids) {
//            LiveData<List<User>> listLiveData = userDao.getUserList();
//            return listLiveData;
//        }
//
//        @Override
//        protected void onPostExecute(LiveData<List<User>> listLiveData) {
//            mListLiveDataUsers = listLiveData;
//        }
//    }

}
