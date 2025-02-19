package com.example.cleanshoppinglist.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun delShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItem: ShopItem): ShopItem

    fun getShopList(): List<ShopItem>
}