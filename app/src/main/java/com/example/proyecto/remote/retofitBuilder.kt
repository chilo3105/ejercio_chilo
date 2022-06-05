package com.example.proyecto.remote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface retofitBuilder {
    @GET("products/")
    fun getProductos() : Call<List<productosEntry>>

    companion object {
        private val BASE_URL = "https://fakestoreapi.com/"

        fun create() : retofitBuilder{
            val retofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retofit.create(retofitBuilder::class.java)
        }
    }
}