package com.example.apicallmvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apicallmvvm.viewmodel.MainActivityVM

class MainActivity : AppCompatActivity() {
    private val mainVM : MainActivityVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        mainVM.getUserData()

        mainVM.userData.observe(this){ value ->
            val user = value
            user?.forEach {
                Log.d(
                    "GET_SUCCESS",
                    "User created: ${it?.firstname} ${it?.lastname}, ID: ${it?._id}"
                )
            }
        }

    }
}