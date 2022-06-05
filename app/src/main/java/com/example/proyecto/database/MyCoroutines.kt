package com.example.proyecto.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


    class MyCoroutines(private val priductDao: PriductDao) {



        suspend fun save(product: Product) = withContext(Dispatchers.IO){
            priductDao.save(product.toEntity())
        }

        suspend fun delete (product: Product) = withContext(Dispatchers.IO){
            priductDao.delete(product.toEntity())
        }

        suspend fun getProducts(): LiveData<List<Product>> = withContext(Dispatchers.IO){
            return@withContext MutableLiveData(priductDao.getProductsFromDatabase().map{it.toProduct()})
        }

    }
