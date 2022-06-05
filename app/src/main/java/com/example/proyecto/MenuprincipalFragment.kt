package com.example.proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.proyecto.database.Product
import com.example.proyecto.databinding.FragmentMenuprincipalBinding
import com.example.proyecto.remote.productosEntry
import com.example.proyecto.remote.retofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MenuprincipalFragment : Fragment(), CallbackAction {

     private lateinit var binding: FragmentMenuprincipalBinding
    private val model : Model by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuprincipalBinding.inflate(layoutInflater)

        val retrofit = retofitBuilder.create()
        val response = retrofit.getProductos()

        response.enqueue(object : Callback<List<productosEntry>>{

            override fun onResponse(call: Call<List<productosEntry>>, response : Response<List<productosEntry>>){
                var listaproductos:List<productosEntry>? = response.body()
                if(listaproductos!=null) {
                    binding.rvMenuPrincipal.adapter = MainAdapter(listaproductos, this@MenuprincipalFragment)

                    var lista = listaproductos.shuffled().subList(0, 5)

                    if(lista!=null) {
                    binding.rvMenuRndom.adapter = RandomAdapter(lista)}
                }
            }

            override fun onFailure(call: Call<List<productosEntry>>, t: Throwable){
                Log.i("falllo ***", t.toString())
            }
        })

        return binding.root
    }

    override fun onClick(product: Product) {
        model.guardaProducto( product
        )
    }


}
