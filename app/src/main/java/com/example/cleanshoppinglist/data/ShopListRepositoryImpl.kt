package com.example.cleanshoppinglist.data

import com.example.cleanshoppinglist.domain.ShopItem
import com.example.cleanshoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFAINED_ID){  // Добавление id новым элементам
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun delShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldItem = getShopItem(shopItem)
        shopList.remove(oldItem)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItem: ShopItem): ShopItem {
        return shopList.find {it.id == shopItem.id} ?:
        throw RuntimeException("Element with id ${shopItem.id} not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList
    }
}