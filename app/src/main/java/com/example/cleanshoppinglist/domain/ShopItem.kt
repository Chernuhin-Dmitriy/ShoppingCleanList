package com.example.cleanshoppinglist.domain

data class ShopItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFAINED_ID
) {

    companion object{

        const val UNDEFAINED_ID = -1
    }
}