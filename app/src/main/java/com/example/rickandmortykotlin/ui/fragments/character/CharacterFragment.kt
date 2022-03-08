package com.example.rickandmortykotlin.ui.fragments.character


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.rickandmortykotlin.R
import com.example.rickandmortykotlin.databinding.FragmentCharacterBinding
import com.example.rickandmortykotlin.ui.adapters.CharacterAdapter
import com.example.rickandmortykotlin.ui.adapters.CommonLoadStateAdapter
import com.example.rickandmortykotlin.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment :
    BaseFragment<CharacterViewModel, FragmentCharacterBinding>(R.layout.fragment_character) {

    private val viewModel: CharacterViewModel by viewModels()
    private lateinit var binding: FragmentCharacterBinding
    private val characterAdapter: CharacterAdapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()

    }

    override fun setupRequest() {
        viewModel.fetchCharacters().observe(viewLifecycleOwner) {
            lifecycleScope.launchWhenStarted {
                characterAdapter.submitData(it)
            }
        }

    }

    private fun setupRecycler() = with(binding.recyclerCharacter) {
        adapter = characterAdapter.withLoadStateFooter(CommonLoadStateAdapter {
            characterAdapter.refresh()
        })
        characterAdapter.addLoadStateListener { loadStates ->
            this.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }


}





