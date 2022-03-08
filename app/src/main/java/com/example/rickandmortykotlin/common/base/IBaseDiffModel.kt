package com.example.rickandmortykotlin.ui.base

import androidx.recyclerview.widget.DiffUtil

interface IBaseDiffModel {
    val id: Int
    override fun equals(other: Any?): Boolean

}

class BaseDiffUtilItemCallBack<T : IBaseDiffModel> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

}
