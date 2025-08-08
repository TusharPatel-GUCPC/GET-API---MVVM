package com.example.apicallmvvm.di

import com.example.apicallmvvm.api.AuthenticationService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppModule {
    companion object{
        fun getApiService(): AuthenticationService {
            // API response interceptor
            val loggingInterceptor = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

            // Client
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            // Retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3500/")
                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
                .build()

            return retrofit.create(AuthenticationService::class.java)
        }
    }
}