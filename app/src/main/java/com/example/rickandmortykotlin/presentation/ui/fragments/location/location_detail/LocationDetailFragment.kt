package com.example.rickandmortykotlin.presentation.ui.fragments.location.location_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.rickandmortykotlin.R
import com.example.rickandmortykotlin.common.base.BaseFragment
import com.example.rickandmortykotlin.databinding.FragmentLocationDetailBinding
import com.example.rickandmortykotlin.presentation.UIState
import com.example.rickandmortykotlin.presentation.ui.fragments.location.LocationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationDetailFragment :
    BaseFragment<LocationDetailViewModel, FragmentLocationDetailBinding>() {
    override val viewModel: LocationDetailViewModel by viewModel()
    override lateinit var binding: FragmentLocationDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchLocationId(LocationDetailFragmentArgs.fromBundle(requireArguments()).id)
        setupRequest()

    }

    override fun setupRequest() = with(binding) {
        viewModel.locationDetailState.subscribe {
            when (it) {
                is UIState.Loading -> {
                }
                is UIState.Error -> {
                    Toast.makeText(requireActivity(), it.massage, Toast.LENGTH_SHORT).show()
                }
                is UIState.Success -> {
                    it.data.let { data ->
                        tvNameLocationDetail.text = data.name
                        tvLocationDetail.text = data.created
                        tvTypeLocationDetail.text = data.type
                        tvIdLocationDetail.text = data.dimension

                    }
                }
            }
        }
    }
}


