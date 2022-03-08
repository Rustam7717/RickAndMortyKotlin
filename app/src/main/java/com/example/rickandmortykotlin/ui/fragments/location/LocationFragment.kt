package com.example.rickandmortykotlin.ui.fragments.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.rickandmortykotlin.R
import com.example.rickandmortykotlin.databinding.FragmentLocationBinding
import com.example.rickandmortykotlin.ui.adapters.CommonLoadStateAdapter
import com.example.rickandmortykotlin.ui.adapters.LocationAdapter
import com.example.rickandmortykotlin.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment :
    BaseFragment<LocationViewModel, FragmentLocationBinding>(R.layout.fragment_location) {

    private val viewModel: LocationViewModel by viewModels()
    private lateinit var binding: FragmentLocationBinding
    private val locationAdapter: LocationAdapter = LocationAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
    }


    override fun setupRequest() {
        viewModel.fetchLocations().observe(viewLifecycleOwner) {
            lifecycleScope.launchWhenStarted {
                locationAdapter.submitData(it)
            }

        }

    }

    private fun setupRecycler() = with(binding.recyclerLocation) {
        adapter = locationAdapter.withLoadStateFooter(CommonLoadStateAdapter {
            locationAdapter.refresh()
        })
        locationAdapter.addLoadStateListener { loadStates ->
            this.isVisible = loadStates.refresh is LoadState.NotLoading

        }
    }


}