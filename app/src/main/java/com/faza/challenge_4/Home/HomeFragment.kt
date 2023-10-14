package com.faza.challenge_4.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.faza.challenge_4.R
import com.faza.challenge_4.data.MenuDataImpl
import com.faza.challenge_4.databinding.FragmentHomeBinding
import com.faza.challenge_4.menu.Menu

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        val recyclerView = binding.rvListMenu
        val isGrid = true

        recyclerView.layoutManager = if (isGrid) GridLayoutManager(requireContext(), 2) else LinearLayoutManager(requireContext())
        val menuList = MenuDataImpl().getMenuData()
        val menuAdapter = MenuAdapter(isGrid, menuList)

        menuAdapter.setOnItemClickListener { menu ->
            val bundle = bundleOf("item" to menu)
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment, args = bundle)

        }
        recyclerView.adapter = menuAdapter

        return view
    }

}