package com.geekbrains.kotlinmvvm.di

import com.geekbrains.kotlinmvvm.framework.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel()}
}