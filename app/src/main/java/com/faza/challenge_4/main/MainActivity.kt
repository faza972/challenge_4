package com.faza.challenge_4.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.faza.challenge_4.R
import com.faza.challenge_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}