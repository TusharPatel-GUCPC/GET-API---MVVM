package com.example.apicallmvvm.api

import com.example.apicallmvvm.model.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface AuthenticationService {
    @GET("/user")
    fun getUsers(): Call<List<UserModel>>
}