package com.faza.challenge_4.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory (private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(application) as T
        }else if (modelClass.isAssignableFrom(CartViewModel::class.java)){
            return CartViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}