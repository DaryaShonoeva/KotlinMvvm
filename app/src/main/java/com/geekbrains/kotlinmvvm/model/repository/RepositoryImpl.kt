package com.geekbrains.kotlinmvvm.model.repository

import com.geekbrains.kotlinmvvm.model.entities.Description

class RepositoryImpl : Repository{
    override fun getFilmFromServer() = Description()

    override fun getFilmFromLocalStorage() = Description()

}