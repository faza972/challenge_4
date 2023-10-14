package com.faza.challenge_4.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import coil.load
import com.faza.challenge_4.Home.SharedPreference
import com.faza.challenge_4.R
import com.faza.challenge_4.databinding.FragmentDetailBinding
import com.faza.challenge_4.menu.Menu
import com.faza.challenge_4.viewModel.DetailViewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    private var isGrid = false
    private var menu: Menu? = null
    private lateinit var sharedPreference: SharedPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

//        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
//        sharedPreference = SharedPreference(this)
//
//        viewModel.menuCart.observe(this) { data ->
//            binding.
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showMenuData()
        setOnClickListener()
        mViewModel()
        addToCart()
    }

    private fun mViewModel() {

        binding.jmlPesanan.setOnClickListener {
            viewModel.increment()
        }

        binding.krgpesanan.setOnClickListener {
            viewModel.decrement()
        }

    }

    private fun setOnClickListener() {
        binding.Lokasi.setOnClickListener{
            navigateToGoogleMaps()
        }
    }

    private fun navigateToGoogleMaps() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:-6.3016,$106.65337"))
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }
    private fun addToCart() {
        binding.pesanMkn.setOnClickListener {
            viewModel.addToCart()

            findNavController().navigate(R.id.action_detailFragment_to_cartFragment)
        }
    }

    private fun showMenuData() {
        menu = arguments?.getParcelable("menu")
        menu?.let {

                // Tampilkan detail menu di tampilan
                binding.tvDetailName.text = menu?.name
                binding.tvDetailPrice.text = menu?.price.toString()
                binding.ivDetailImage.load(menu?.image) {
                    crossfade(true)
                }
                binding.tvDetaildesk.text = menu?.desc
                viewModel.initSelectItem(it)
            }

    }
}
