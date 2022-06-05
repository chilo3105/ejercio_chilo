package com.example.proyecto.database

class Product(id:String, titulo:String, precio: Double, descripcion:String, categoria:String, imagen:String, user_id:Int
) {

    val id: String = id
    val titulo: String  = titulo
    val precio: Double = precio
    val descripcion: String = descripcion
    val categoria: String = categoria
    val imagen: String = imagen
    val user_id: Int = user_id
}



fun Product.toEntity() = ProductEntity(
    id,
    titulo,
    precio,
    descripcion,
    categoria,
    imagen,
    user_id
)