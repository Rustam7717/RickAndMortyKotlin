package com.example.rickandmortykotlin.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortykotlin.data.network.models.character.Character
import com.example.rickandmortykotlin.databinding.ItemCharacterBinding
import com.example.rickandmortykotlin.common.base.BaseDiffUtilItemCallBack

class CharacterAdapter(
    val onItemClick: (id:Int) ->Unit
) :
    PagingDataAdapter<Character, CharacterAdapter.CharacterViewHolder>(BaseDiffUtilItemCallBack()) {

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) = with(binding) {
          itemView.setOnClickListener {
              onItemClick(character.id)
          }
            tvName.text = character.name
            tvStatus.text = character.status
            tvGender.text = character.gender
            Glide.with(binding.ivCharacter).load(character.image).into(binding.ivCharacter)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
         getItem(position)?.let { holder.bind(it) }
    }
}