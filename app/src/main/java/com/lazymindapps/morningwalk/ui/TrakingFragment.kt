package com.lazymindapps.morningwalk.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.GoogleMap
import com.lazymindapps.morningwalk.R
import com.lazymindapps.morningwalk.databinding.FragmentTrakingBinding
import com.lazymindapps.morningwalk.service.TrackingService
import com.lazymindapps.morningwalk.utli.Constants.ACTION_START_RESUME
import com.lazymindapps.morningwalk.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TrakingFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()
    private var map: GoogleMap? = null
    lateinit var binding: FragmentTrakingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTrakingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mapView.onCreate(savedInstanceState)
        binding.btnToggleRun.setOnClickListener{
            sendCommandService(ACTION_START_RESUME)
        }

        binding.mapView?.getMapAsync {
            map = it
        }


    }

    private fun sendCommandService(action:String) = Intent(requireContext(),TrackingService::class.java)
        .also {
            it.action = action
            requireContext().startService(it)
        }


    override fun onPause() {
        super.onPause()
        binding.mapView?.onPause()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView?.onResume()
    }

    override fun onStart() {
        super.onStart()
        binding.mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView?.onStop()
    }


    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView?.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView?.onSaveInstanceState(outState)
    }


}