package com.faza.challenge_4.detail

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.faza.challenge_4.R
import com.faza.challenge_4.databinding.FragmentOrderBinding
import com.faza.challenge_4.viewModel.CartViewModel
import com.faza.challenge_4.viewModel.DetailViewModel

class OrderFragment : Fragment() {
    private lateinit var binding: FragmentOrderBinding
    private lateinit var cartViewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCartViewModel()
        setCorfirOrder()
        setShowOrder()
    }

    private fun setShowOrder() {
        val viewModelFactory = ViewModelFactory(requireActivity().application)
    }

    private fun setCorfirOrder() {
        TODO("Not yet implemented")
    }

    private fun setCartViewModel() {
        TODO("Not yet implemented")
    }
}

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create (modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(application) as T
        }else if (modelClass.isAssignableFrom(CartViewModel::class.java)){
            return CartViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
