package com.faza.challenge_4.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.faza.challenge_4.data.MenuDataImpl
import com.faza.challenge_4.databinding.ItemMenuGridBinding
import com.faza.challenge_4.databinding.ItemMenuLinearBinding
import com.faza.challenge_4.menu.Menu

class MenuAdapter(private val isGrid: Boolean,  val data: List<Menu>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemClickListener: ((Menu) -> Unit)? = null
    fun setOnItemClickListener(listener: (Menu) -> Unit) {
        itemClickListener = listener
    }
    companion object {
        private const val VIEW_TYPE_lINEAR = 0
        private const val VIEW_TYPE_GRID = 1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (isGrid) {
            val gridBinding = ItemMenuGridBinding.inflate(inflater, parent, false)
            GridMenuHolder(gridBinding)
        } else {
            val linearBinding = ItemMenuLinearBinding.inflate(inflater, parent, false)
            LinearMenuHolder(linearBinding)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GridMenuHolder -> holder.onBind(data[position])
            is LinearMenuHolder -> holder.onBind(data[position])
        }
        val menu = data[position]

        holder.itemView.setOnClickListener{
            itemClickListener?.invoke(menu)
        }
    }
    override fun getItemViewType(position: Int): Int {
        return if (isGrid) VIEW_TYPE_GRID else VIEW_TYPE_lINEAR
    }
}
class GridMenuHolder(private val binding: ItemMenuGridBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: Menu) {
        binding.ivImageGrid.load(data.image){
            crossfade(true)
        }
        binding.tvNameGrid.text = data.name
        binding.tvPriceGrid.text = data.price.toString()
        // Bind other views if needed
    }
}

class LinearMenuHolder(private val binding: ItemMenuLinearBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: Menu) {
        binding.ivMenuImage.load(data.image){
            crossfade(true)
        }
        binding.tvMenuName.text = data.name
        binding.tvMenuPrice.text = data.price.toString()
        // Bind other views if needed
    }
}


