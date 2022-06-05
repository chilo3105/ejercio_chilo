package com.example.proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyecto.databinding.FragmentSearchBinding
import com.example.proyecto.remote.productosEntry
import com.example.proyecto.remote.retofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.listOf as listOf

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(layoutInflater)

        binding.btnSearch.setOnClickListener {
            val database = retofitBuilder.create()
            val response = database.getProductos()

            val categoria : String = binding.etSearch.text.toString()
            if(categoria.isNotEmpty()) {
                response.enqueue(object : Callback<List<productosEntry>> {
                    override fun onResponse(
                        call: Call<List<productosEntry>>,
                        response: Response<List<productosEntry>>
                    ) {
                        var products: List<productosEntry>? = response.body()
                        if (products != null) {
                            var result: List<productosEntry>? = null
                            for (product in products) {

                                if(product.category == categoria) {
                                    if(result == null){
                                    result = listOf(product)}
                                    else{
                                        result = result + listOf(product)
                                    }
                                }
                            }
                            if(result != null){
                            binding.rvSearchProduct.adapter = SearchAdapter(result)
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<productosEntry>>, t: Throwable) {
                    }
                })
            }
        }
        return binding.root
    }

}