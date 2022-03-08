package com.example.rickandmortykotlin.ui.fragments.episode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.rickandmortykotlin.R
import com.example.rickandmortykotlin.databinding.FragmentEpisodeBinding
import com.example.rickandmortykotlin.ui.adapters.CommonLoadStateAdapter
import com.example.rickandmortykotlin.ui.adapters.EpisodeAdapter
import com.example.rickandmortykotlin.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeFragment :
BaseFragment<EpisodeViewModel, FragmentEpisodeBinding>(R.layout.fragment_episode){

    private val viewModel: EpisodeViewModel by viewModels()
    private lateinit var binding: FragmentEpisodeBinding
    private val episodeAdapter: EpisodeAdapter = EpisodeAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEpisodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
    }

    override fun setupRequest() {
        viewModel.fetchEpisodes().observe(viewLifecycleOwner){
            lifecycleScope.launchWhenStarted {
                episodeAdapter.submitData(it)
            }
        }
    }



    private fun setupRecycler()  = with(binding.recyclerEpisode){
        adapter= episodeAdapter.withLoadStateFooter(CommonLoadStateAdapter{
            episodeAdapter.refresh()
        })
        episodeAdapter.addLoadStateListener { loadStates ->
            this.isVisible = loadStates.refresh is LoadState.NotLoading

        }

    }

}