package com.faza.challenge_4.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.faza.challenge_4.R
import com.faza.challenge_4.SharedPreference
import com.faza.challenge_4.adapter.MenuAdapter
import com.faza.challenge_4.data.MenuDataImpl
import com.faza.challenge_4.databinding.FragmentHomeBinding
import com.faza.challenge_4.model.Menu
import com.faza.challenge_4.viewModel.HomeViewModel


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var preference: SharedPreference
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var menuAdapter: MenuAdapter
    private var isGrid: Boolean = true
    private val dataMenu = ArrayList<Menu>()
    private var layoutMode = true

    private val drawable = arrayListOf(
        R.drawable.button_list,
        R.drawable.ic_grid
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        preference = SharedPreference(requireContext())

        homeViewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        homeViewModel.menuView.value = preference.getPreference()

        menuAdapter = MenuAdapter(dataMenu, homeViewModel.menuView.value ?: true)
        binding.rvListMenu.adapter = menuAdapter

        binding.rvListMenu.setHasFixedSize(true)
        if (dataMenu.isEmpty()) {
            dataMenu.addAll(getMenu())
        }
        showRecyclerView()

        homeViewModel.menuView.observe(viewLifecycleOwner) {
            toggleCurrent()
        }

        homeViewModel.menuItem.observe(viewLifecycleOwner) { menuItem ->
            updateHome(menuItem)
        }

        clickItem()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toggleButton = binding.ivGantiMode
        toggleButton.setOnClickListener {
            isGrid = !isGrid
            toggleCurrent()
            toggleImageViewImage(toggleButton)
        }
        toggleCurrent()
    }
    private fun showRecyclerView() {
        binding.rvListMenu.layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.rvListMenu.adapter = menuAdapter
    }

    private fun toggleImageViewImage(imageView: ImageView) {
        imageView.setImageResource(drawable[if (isGrid) 0 else 1])
    }

    private fun clickItem() {
        menuAdapter = MenuAdapter(dataMenu, homeViewModel.menuView.value ?: true) { item ->
            val bundle = bundleOf("item" to item)
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment, args = bundle)
        }
        binding.rvListMenu.adapter = menuAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateHome(menuItem: ArrayList<Menu>){
//        menuAdapter.reloadData(menuItem)
        menuAdapter.isGrid = homeViewModel.menuView.value?: true
        binding.rvListMenu.adapter?.notifyDataSetChanged()
    }

    private fun toggleCurrent(){
        val togleImage = binding.ivGantiMode
        val currentLayout: Boolean = homeViewModel.menuView.value ?: preference.getPreference()

        toggleRecyclerView(currentLayout)
        togleImage.setImageResource(if (currentLayout) R.drawable.ic_grid else R.drawable.button_list)

        togleImage.setOnClickListener {
            val grid =!currentLayout
            homeViewModel.menuView.value = grid
            preference.savePrefLayout(grid)
        }
    }

    private fun toggleRecyclerView(viewList: Boolean) {
        dataMenu.clear()

        layoutMode = if (viewList) {
            gridMenu()
            true
        } else {
            linearMenu()
            false
        }
        val adapter = MenuAdapter(getMenu(),true){
            clickItem()
        }
        dataMenu.addAll(getMenu())
        binding.rvListMenu.adapter = adapter
    }

//    private fun navigateToDetail() {
//        findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
//    }

    @SuppressLint("Recycle")
    private fun getMenu(): List<Menu> {
        val menuData = MenuDataImpl()
        return menuData.getMenuData()
    }

    private fun linearMenu() {
        binding.rvListMenu.layoutManager = LinearLayoutManager(requireActivity())
        val adapterFood = MenuAdapter(dataMenu, isGrid = false)
        binding.rvListMenu.adapter = adapterFood
    }

    private fun gridMenu() {
        binding.rvListMenu.layoutManager = GridLayoutManager(requireContext(), 2)
        val adapterGrid = MenuAdapter(dataMenu, isGrid = true)
        binding.rvListMenu.adapter = adapterGrid
    }
}