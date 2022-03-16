package com.example.rickandmortykotlin.presentation.ui.fragments.episode.episode_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.rickandmortykotlin.common.base.BaseFragment
import com.example.rickandmortykotlin.databinding.FragmentEpisodeDetailBinding
import com.example.rickandmortykotlin.presentation.UIState
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeDetailFragment :
    BaseFragment<EpisodeDetailViewModel, FragmentEpisodeDetailBinding>() {

    override val viewModel: EpisodeDetailViewModel by viewModel()
    override lateinit var binding: FragmentEpisodeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEpisodeDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchEpisodeId(EpisodeDetailFragmentArgs.fromBundle(requireArguments()).id)
        setupRequest()
    }

    override fun setupRequest() = with(binding) {
        viewModel.episodeDetailState.subscribe {
            when (it) {
                is UIState.Loading -> {
                }
                is UIState.Error -> {
                    Toast.makeText(requireActivity(), it.massage, Toast.LENGTH_SHORT).show()
                }
                is UIState.Success -> {
                    it.data.let { data ->
                        tvNameEpisodeDetail.text = data.name
                        tvEpisodeDetail.text = data.episode
                        tvAirDateEpisodeDetail.text = data.air_date
                        tvCreateDetail.text = data.created

                    }
                }
            }
        }
    }
}

