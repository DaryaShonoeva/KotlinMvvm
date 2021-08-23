package com.geekbrains.kotlinmvvm.model.entities

import com.geekbrains.kotlinmvvm.model.entities.Name

data class Description(
    val name: Name = getDefaultName(),
    val categories: String = " abc ",
    val duration: Int = 0,
    val rating: Double = 0.0,
    val budget: Double = 0.0,
    val description: String = " abc "
)
fun getDefaultName() = Name("Человне паук")
