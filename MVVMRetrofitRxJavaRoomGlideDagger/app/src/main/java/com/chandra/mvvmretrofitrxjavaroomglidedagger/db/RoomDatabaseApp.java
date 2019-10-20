package com.chandra.mvvmretrofitrxjavaroomglidedagger.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.model.User;

@Database(entities = UserTable.class, version = 5, exportSchema = false)
public abstract class RoomDatabaseApp extends RoomDatabase {
    private static final String TAG = "RoomDatabaseApp";
    private static RoomDatabaseApp roomDatabaseAppInstance;

    public abstract UserDao userDao();

    public static synchronized RoomDatabaseApp getRoomDatabaseAppInstance(Application mContext) {

       if(null == roomDatabaseAppInstance){
           roomDatabaseAppInstance = Room.databaseBuilder(mContext.getApplicationContext(),RoomDatabaseApp.class,"user_table")
                   .fallbackToDestructiveMigration()
                           .addCallback(roomCallback)
                   .build();
       }

        return roomDatabaseAppInstance;
    }

    public static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new CreateUsersDBAsync(roomDatabaseAppInstance).execute();
        }

    };

    private static class CreateUsersDBAsync extends AsyncTask<Void, Void, Void> {


        private UserDao userDao;

        public CreateUsersDBAsync(RoomDatabaseApp db) {
            userDao = db.userDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            UserTable userTable1 = new UserTable(1, "mojombo", "https://avatars0.githubusercontent.com/u/1?v=4");
            userDao.insertUser(userTable1);
            return null;
        }
    }
}

