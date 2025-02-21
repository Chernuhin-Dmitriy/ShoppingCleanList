package com.example.cleanshoppinglist.domain

class DelShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun delShopItem(shopItem: ShopItem) {
        shopListRepository.delShopItem(shopItem)
    }
}