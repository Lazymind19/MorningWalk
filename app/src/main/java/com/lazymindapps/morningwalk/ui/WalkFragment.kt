package com.lazymindapps.morningwalk.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lazymindapps.morningwalk.R
import com.lazymindapps.morningwalk.databinding.FragmentWalkBinding
import com.lazymindapps.morningwalk.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WalkFragment : Fragment() {
    private val viewModel:MainViewModel by viewModels()
    lateinit var binding :FragmentWalkBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWalkBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.action_walkFragment_to_trakingFragment)
        }
    }

    
}