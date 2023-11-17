package com.faza.challenge_4.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.faza.challenge_4.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
   private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // showUserData()
    }

//    private val viewModel : ProfileViewModel by viewModels {
//        SimpleViewModelFactory.create(createViewModel())
//    }

//    private fun createViewModel(): ProfileViewModel {
//        val firebaseAuth = FirebaseAuth.getInstance()
//        val dataSource: FirebaseAuthDataSource = FirebaseAuthDataSourceImpl(firebaseAuth)
//        val user = User(dataSource, firebaseAuth.currentUser?.displayName ?: "",
//            firebaseAuth.currentUser?.email?: "")
//        return ProfileViewModel(user)
//    }

//    private fun showUserData() {
//        val user = viewModel.getUserData()
//        binding.etUsername.setText(user.first)
//        binding.etEmail.setText(user.second)
//        binding.etContact.setText(user.third)
//    }

}