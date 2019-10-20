package com.chandra.mvvmretrofitrxjavaroomglidedagger.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUser(UserTable user);

    @Update
    void updateUser(UserTable user);

    @Delete
    void deleteUser(UserTable user);

    @Query("DELETE FROM user_table")
    void deleteAll();

    @Query("SELECT * FROM user_table")
    LiveData<List<User>> getUserList();
}
