package com.faza.challenge_4.data

import com.faza.challenge_4.R
import com.faza.challenge_4.menu.Menu

interface MenuDataSource {

    fun getMenuData() : List<Menu>
}
class MenuDataImpl() : MenuDataSource {
    override fun getMenuData(): List<Menu> = listOf(
        Menu(
            name = "Ayam Bakar",
            price = "Rp. 50.000",
            image = R.drawable.snack,
            desc = "Ayam bakar dengan olesan madu dan daging empuk"
        ),
        Menu(
            name = "Ayam Goreng",
            price = "Rp. 40.000",
            image = R.drawable.snack,
            desc = "Ayam Goreng dengan tekstur renyah dan kenyal"
        ),
        Menu(
            name = "Ayam Geprek",
            price = "Rp. 40.000",
            image = R.drawable.snack,
            desc = "Ayam geprek dengan sambel matah yang menggugah selera"
        ),
        Menu(
            name = "Sate usus Ayam",
            price = "Rp. 5.000",
            image = R.drawable.snack,
            desc = "Sate usus untuk menemani makan mu tiga kali sehari, Seven days a week!!!"
        )
    )
}