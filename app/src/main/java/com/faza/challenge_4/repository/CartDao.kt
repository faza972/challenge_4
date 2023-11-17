package com.faza.challenge_4.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.faza.challenge_4.model.Cart

@Dao
interface CartDao {

    @Insert
    fun insertCart(cart: Cart)
    @Query("SELECT * FROM CARTORDER ORDER BY id")
    fun getAllCartOrder(): LiveData<List<Cart>>

    @Delete
    fun delete(cart: Cart)

    @Query("DELETE FROM CartOrder WHERE id = :cartId")
    fun deleteCart(cartId: Long)

    @Update
    fun updateCart(cart: Cart)
}