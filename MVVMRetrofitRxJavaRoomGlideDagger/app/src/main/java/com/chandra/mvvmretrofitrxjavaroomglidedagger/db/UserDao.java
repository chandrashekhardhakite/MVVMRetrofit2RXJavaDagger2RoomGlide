package com.chandra.mvvmretrofitrxjavaroomglidedagger.db;

import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.model.User;

@Entity
public interface UserDao {

    @Insert
    void insertUser(User user);



}
