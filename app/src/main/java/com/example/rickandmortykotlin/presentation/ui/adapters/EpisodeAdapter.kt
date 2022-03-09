package com.example.rickandmortykotlin.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortykotlin.data.network.models.episode.Episode
import com.example.rickandmortykotlin.databinding.ItemEpisodeBinding
import com.example.rickandmortykotlin.common.base.BaseDiffUtilItemCallBack as BaseDiffUtilItemCallBack1

class EpisodeAdapter :
    PagingDataAdapter<Episode, EpisodeAdapter.EpisodeViewHolder>(BaseDiffUtilItemCallBack1()) {

    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: Episode) = with(binding) {
            tvEpisodeName.text = episode.name
            tvEpisodeType.text = episode.created
            tvEpisodeTypeLocation.text = episode.episode
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}