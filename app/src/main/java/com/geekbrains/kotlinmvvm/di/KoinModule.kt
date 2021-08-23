package com.geekbrains.kotlinmvvm.di

import com.geekbrains.kotlinmvvm.framework.ui.main.MainViewModel
import com.geekbrains.kotlinmvvm.model.repository.Repository
import com.geekbrains.kotlinmvvm.model.repository.RepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<Repository> { RepositoryImpl()}
    viewModel { MainViewModel(get())}
}