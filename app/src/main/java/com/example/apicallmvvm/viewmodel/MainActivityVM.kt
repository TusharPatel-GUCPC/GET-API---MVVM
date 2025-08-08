package com.example.apicallmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apicallmvvm.di.AppModule
import com.example.apicallmvvm.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityVM : ViewModel() {
    private val _userData = MutableLiveData<List<UserModel>>()
    val userData: LiveData<List<UserModel>> get() = _userData

    fun getUserData(){
        val client = AppModule.getApiService().getUsers()

        client.enqueue(object: Callback<List<UserModel>>{
            override fun onResponse(
                call: Call<List<UserModel>?>,
                response: Response<List<UserModel>?>
            ) {
                if (response.isSuccessful){
                    _userData.postValue(response.body())
                } else{
                    Log.e("API_ERROR", "APIResponse: ${response.code()}")
                }
            }

            override fun onFailure(
                call: Call<List<UserModel>?>,
                t: Throwable
            ) {
                Log.e("API_ERROR", "APIResponse: ${t.message} ")
            }
        })
    }
}