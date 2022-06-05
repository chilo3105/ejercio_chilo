package com.example.proyecto

import com.example.proyecto.database.Product

interface CallbackAction {
    fun onClick(product : Product)
}