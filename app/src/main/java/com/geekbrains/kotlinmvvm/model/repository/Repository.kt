package com.geekbrains.kotlinmvvm.model.repository

import com.geekbrains.kotlinmvvm.model.entities.Description

interface Repository {
    fun getFilmFromServer(): Description
    fun getFilmFromLocalStorage(): Description
}