package com.example.rickandmortykotlin.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortykotlin.data.network.models.location.Location
import com.example.rickandmortykotlin.databinding.ItemLocationBinding
import com.example.rickandmortykotlin.common.base.BaseDiffUtilItemCallBack


class LocationAdapter(
    val onItemClick:(id:Int) -> Unit
) :

    PagingDataAdapter<Location, LocationAdapter.LocationViewHolder>(BaseDiffUtilItemCallBack()) {

    inner class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(location: Location) = with(binding) {
            itemView.setOnClickListener {
                onItemClick(location.id)
            }
            tvLocationName.text = location.name
            tvDimension.text = location.dimension
            tvLocationType.text = location.type
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }


    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}



