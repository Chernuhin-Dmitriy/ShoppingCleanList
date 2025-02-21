package com.example.cleanshoppinglist.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanshoppinglist.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel :: class.java) // инициализируем значением viewModel
        viewModel.shopList.observe(this){   // Подписываемся на shopList и смотрим его лог
            Log.d("MainActivityTest", it.toString())

            if(count == 0) {
                count++
                val item = it[0]
                viewModel.changeEnableState(it[0])
            }
        }
    }
}