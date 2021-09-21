package com.lazymindapps.morningwalk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.lazymindapps.morningwalk.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val navHostFragmentContainer = findNavController(R.id.nav_host_fragment)
        binding.bottomNavigationView.setupWithNavController(navHostFragmentContainer)

        navHostFragmentContainer.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.settingFragment,R.id.walkFragment,R.id.statFragment ->
                    binding.bottomNavigationView.visibility = View.VISIBLE

                else -> binding.bottomNavigationView.visibility = View.GONE
            }
        }





    }
}