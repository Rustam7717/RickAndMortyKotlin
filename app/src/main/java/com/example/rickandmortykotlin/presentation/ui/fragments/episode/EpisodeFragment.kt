package com.example.rickandmortykotlin.presentation.ui.fragments.episode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.example.rickandmortykotlin.databinding.FragmentEpisodeBinding
import com.example.rickandmortykotlin.presentation.ui.adapters.EpisodeAdapter
import com.example.rickandmortykotlin.common.base.BaseFragment
import com.example.rickandmortykotlin.presentation.ui.adapters.CommonLoadStateAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodeFragment :
    BaseFragment<EpisodeViewModel, FragmentEpisodeBinding>() {

    override val viewModel: EpisodeViewModel by viewModel()
    override lateinit var binding: FragmentEpisodeBinding
    private val episodeAdapter: EpisodeAdapter = EpisodeAdapter(this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
    }

    override fun setupRequest() {
        viewModel.fetchEpisodes().observe(viewLifecycleOwner) {
            lifecycleScope.launchWhenStarted {
                episodeAdapter.submitData(it)
            }
        }
    }

    private fun setupRecycler() = with(binding.recyclerEpisode) {
        adapter = episodeAdapter.withLoadStateFooter(CommonLoadStateAdapter {
            episodeAdapter.refresh()
        })
        episodeAdapter.addLoadStateListener { loadStates ->
            this.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
          EpisodeFragmentDirections
                .actionEpisodeFragmentToEpisodeDetailFragment(id)
        )
    }
}
