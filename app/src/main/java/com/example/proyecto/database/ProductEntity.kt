package com.example.proyecto.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO add TABLE_USERS constant
@Entity(tableName = TABLE_PRODUCTS)
data class ProductEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "title") val titulo: String,
    val precio: Double,
    val descripcion: String,
    val categoria: String,
    val imagen: String,
    val user_id : Int
)

fun ProductEntity.toProduct() = Product( id, titulo, precio, descripcion, categoria, imagen, user_id )