package com.chandra.mvvmretrofitrxjavaroomglidedagger.db;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class RoomDatabaseApp extends RoomDatabase {
    private static final String TAG = "RoomDatabaseApp";
    private static RoomDatabaseApp roomDatabaseAppInstance;

    public abstract UserDao restaurantMenuDao();


    public static RoomDatabaseApp roomDatabaseAppInstance(Application mContext) {
        if (roomDatabaseAppInstance == null) {
            if (roomDatabaseAppInstance == null) {
                synchronized (UserDao.class) {
                    if (roomDatabaseAppInstance == null) {
//                    get database from Asset folder
//                    copyDatabase(mContext, "test_menu");
                        roomDatabaseAppInstance = Room.databaseBuilder(mContext.getApplicationContext(), RoomDatabaseApp.class, "test_user")
                                .fallbackToDestructiveMigration().
                                        build();
                    }
                }
            }
        }
        return roomDatabaseAppInstance;
    }
}

