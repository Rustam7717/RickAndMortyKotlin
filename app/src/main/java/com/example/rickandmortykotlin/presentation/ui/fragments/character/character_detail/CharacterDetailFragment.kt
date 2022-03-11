package com.example.rickandmortykotlin.presentation.ui.fragments.character.character_detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.rickandmortykotlin.R
import com.example.rickandmortykotlin.databinding.FragmentCharacterDetailBinding
import com.example.rickandmortykotlin.common.base.BaseFragment
import com.example.rickandmortykotlin.presentation.UIState
import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterDetailFragment :
    BaseFragment<CharacterDetailViewModel, FragmentCharacterDetailBinding>() {

    override val viewModel: CharacterDetailViewModel by viewModel()
    override lateinit var binding: FragmentCharacterDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchCharacterId(CharacterDetailFragmentArgs.fromBundle(requireArguments()).id)
        setupRequests()
    }

    private fun setupRequests() = with(binding) {
        viewModel.characterDetailState.subscribe {
            when (it) {
                is UIState.Loading -> {
                }
                is UIState.Error -> {
                    Toast.makeText(requireActivity(), it.massage, Toast.LENGTH_SHORT).show()
                }
                is UIState.Success -> {
                    it.data.let { data ->
                        tvCharacterFullNameDetail.text = data.name
                        tvGender.text = data.gender
                        tvSpices.text = data.species
                        tvStatus.text = data.status
                        Glide.with(ivAvatar).load(data.image).into(ivAvatar)
                    }
                }
            }
        }
    }
}



