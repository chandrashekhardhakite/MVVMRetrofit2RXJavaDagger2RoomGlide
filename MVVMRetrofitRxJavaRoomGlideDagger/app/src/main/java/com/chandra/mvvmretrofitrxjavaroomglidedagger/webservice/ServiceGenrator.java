package com.chandra.mvvmretrofitrxjavaroomglidedagger.webservice;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.model.User;
import com.chandra.mvvmretrofitrxjavaroomglidedagger.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenrator {


    private static final String TAG = "ServiceGenrator";

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();
    private static UserApi userApi = retrofit.create(UserApi.class);

    public static LiveData<List<User>> getUsers() {
        Log.d(TAG, "getUserApi: called" + (userApi == null));
        final MutableLiveData<List<User>> users = new MutableLiveData<>();
        userApi.getUserList().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d(TAG, "onResponse: " + call);
                if (response.isSuccessful()) {
                    users.setValue(response.body());
                    Log.d(TAG, "onResponse: " + users.getValue().get(0).getAvatarUrl());
                } else {
                    Log.d(TAG, "onResponse: Error Occoured" + response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return users;
    }
}


