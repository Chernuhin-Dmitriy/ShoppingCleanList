package com.example.cleanshoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanshoppinglist.data.ShopListRepositoryImpl
import com.example.cleanshoppinglist.domain.DelShopItemUseCase
import com.example.cleanshoppinglist.domain.EditShopItemUseCase
import com.example.cleanshoppinglist.domain.GetShopItemUseCase
import com.example.cleanshoppinglist.domain.GetShopListUseCase
import com.example.cleanshoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {    // ViewModel не зависит от контекста, поэтому не используем его напрямую из AndroidViewModel

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val delShopItemUseCase = DelShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {                                  // Нет вз, передаем в LiveData
        val list = getShopListUseCase.getShopList()
        shopList.value = list                           // value в главноем потоке/else - postValue
    }




}