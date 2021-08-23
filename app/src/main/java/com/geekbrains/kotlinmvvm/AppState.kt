package com.geekbrains.kotlinmvvm

import com.geekbrains.kotlinmvvm.model.entities.Description
import java.lang.Appendable

sealed class AppState {
    data class Success(val filmData: Description) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
