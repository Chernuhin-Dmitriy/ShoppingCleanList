package com.example.cleanshoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun delShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItem: ShopItem): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>
}