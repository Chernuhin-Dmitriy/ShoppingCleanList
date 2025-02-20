package com.example.cleanshoppinglist.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanshoppinglist.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel :: class.java) // инициализируем значением viewModel
        viewModel.shopList.observe(this){   // Подписываемся на изменения в shopList, но не обновляет его
            Log.d("MainActivityTest", it.toString())
        }
        viewModel.getShopList() // Обновляет live data и сам список shopList
    }
}