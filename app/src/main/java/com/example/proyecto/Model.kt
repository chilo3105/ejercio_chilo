package com.example.proyecto

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto.database.DatabaseManager
import com.example.proyecto.database.MyCoroutines
import com.example.proyecto.database.Product
import kotlinx.coroutines.launch

class Model: ViewModel() {

    val savedProducts = MutableLiveData<List<Product>>()

    fun guardaProducto(product: Product){
        viewModelScope.launch{
            val priductDao = DatabaseManager.instance.database.priductDao()
            MyCoroutines(priductDao).save(product)
        }
    }

    fun deleteUser(product: Product){
        viewModelScope.launch{
            val priductDao = DatabaseManager.instance.database.priductDao()
            MyCoroutines(priductDao).delete(product)
        }
    }

    fun getUsers(){
        viewModelScope.launch{
            val priductDao = DatabaseManager.instance.database.priductDao()
            savedProducts.value = MyCoroutines(priductDao).getProducts().value
        }
    }

}