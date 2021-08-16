package com.geekbrains.kotlinmvvm

import java.lang.Appendable

sealed class AppState {
    data class Success(val weatherData: Any) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
