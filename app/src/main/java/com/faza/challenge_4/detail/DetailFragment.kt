package com.faza.challenge_4.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.faza.challenge_4.R
import com.faza.challenge_4.databinding.FragmentDetailBinding
import com.faza.challenge_4.menu.Menu

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showMenuData()
        setOnClickListener()
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

    private val menu: Menu? by lazy {
        DetailFragmentArgs.fromBundle(arguments as Bundle).menu
    }
    private fun showMenuData() {
        menu?.let { m ->
            binding.apply {

                // Tampilkan detail menu di tampilan
                tvDetailName.text = m.name
                tvDetailPrice.text = m.price
                ivDetailImage.load(m.image) {
                    crossfade(true)
                }
                tvDetaildesk.text = m.desc
            }
        }
    }
}
