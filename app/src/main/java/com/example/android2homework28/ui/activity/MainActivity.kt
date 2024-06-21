package com.example.android2homework28.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.android2homework28.R
import com.example.android2homework28.databinding.ActivityMainBinding
import com.example.android2homework28.utils.PreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =  supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        val preference = PreferenceHelper()
        preference.unit(this)

        val check = preference.saveBoolean

        if(check == false){
            navController.navigate(R.id.onBoardFragment)
        }else{
            navController.navigate(R.id.noteFragment)
        }
    }
}