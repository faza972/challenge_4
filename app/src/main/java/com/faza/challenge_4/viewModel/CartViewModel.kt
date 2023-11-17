package com.faza.challenge_4.viewModel

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faza.challenge_4.model.Cart
import com.faza.challenge_4.repository.CartRepository


class CartViewModel (application: Application) : ViewModel(){
    private val repo: CartRepository = CartRepository(Application())

    val allOrder: LiveData<List<Cart>> = repo.getAllCartOrder()

    fun deleteCart(cartId: Long) {
       repo.deleteCart(cartId)
    }

    private fun updateQuantity (cart: Cart) {
        repo.update(cart)
    }

    @SuppressLint("SuspiciousIndentation")
    fun increment(cart: Cart){
        val total = cart.quantity + 1
        cart.totalAll = cart.foodPrice * total
        updateQuantity(cart)
    }

    fun decrement(cart: Cart) {
        val total = cart.quantity - 1
        cart.totalAll = cart.foodPrice * total
        updateQuantity(cart)
    }

}
