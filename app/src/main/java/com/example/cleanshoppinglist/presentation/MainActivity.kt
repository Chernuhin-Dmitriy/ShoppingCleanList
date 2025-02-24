package com.example.cleanshoppinglist.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanshoppinglist.R
import com.example.cleanshoppinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var llShoplist: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llShoplist = findViewById(R.id.ll_shop_list)
        viewModel = ViewModelProvider(this).get(MainViewModel :: class.java) // инициализируем значением viewModel
        viewModel.shopList.observe(this){   // Подписываемся на shopList и смотрим его лог
            Log.d("MainActivityTest", it.toString())
            showList(it)
        }
    }

    private fun showList(list: List<ShopItem>){
        for(shopItem in list){
            val layoutId = if(shopItem.enabled) {
                R.layout.item_shop_enabled
            } else{
                R.layout.item_shop_disabled
                }

            val view = LayoutInflater.from(this).inflate(layoutId, llShoplist, false)
            llShoplist.addView(view)
        }
    }
}