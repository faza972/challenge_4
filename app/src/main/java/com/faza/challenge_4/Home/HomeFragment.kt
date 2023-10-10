package com.faza.challenge_4.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val menuAdapter = MenuAdapter(isGrid, data = List<Menu>)

        menuAdapter.setOnItemClickListener { menu ->
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
            findNavController().navigate(action)
        }
        recyclerView.adapter = menuAdapter

        return view
    }
}