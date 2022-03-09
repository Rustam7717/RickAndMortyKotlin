package com.example.rickandmortykotlin.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortykotlin.data.network.models.character.Character
import com.example.rickandmortykotlin.databinding.ItemCharacterBinding
import com.example.rickandmortykotlin.common.base.BaseDiffUtilItemCallBack

class CharacterPagingAdapter :
    PagingDataAdapter<Character, CharacterPagingAdapter.CharacterViewHolder>(
        BaseDiffUtilItemCallBack()
    ) {


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater
                    .from(parent.context), parent, false
            )
        )
    }

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Character) {
            binding.tvName.text = item.name


        }
    }
}