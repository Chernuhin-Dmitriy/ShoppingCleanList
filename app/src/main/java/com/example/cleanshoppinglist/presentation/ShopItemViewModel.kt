package com.example.cleanshoppinglist.presentation

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import com.example.cleanshoppinglist.data.ShopListRepositoryImpl
import com.example.cleanshoppinglist.domain.AddShopItemUseCase
import com.example.cleanshoppinglist.domain.EditShopItemUseCase
import com.example.cleanshoppinglist.domain.GetShopItemUseCase
import com.example.cleanshoppinglist.domain.ShopItem
import com.example.cleanshoppinglist.domain.ShopListRepository

class ShopItemViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    fun getShopItem(shopItemId: Int) {
        val item = getShopItemUseCase.getShopItem(shopItemId)
    }

    fun addShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val validatesFields = validateInput(name, count)
        if(validatesFields){
            val shopItem = ShopItem(name, count, true)
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

    fun editShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val validatesFields = validateInput(name, count)
        if (validatesFields) {
            val shopItem = ShopItem(name, count, true)
            editShopItemUseCase.editShopItem(shopItem)
        }
    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e: Exception) {
            throw RuntimeException("Недопустимые символы")
        }
    }

    private fun validateInput(name: String, count: Int): Boolean{
        var result = true
        if(name.isBlank()){
            //TODO show error input name
            result = false
        }
        if(count <= 0) {
            //TODO show error input name
            result = false
        }
        return result
    }
}