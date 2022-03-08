package com.example.rickandmortykotlin.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortykotlin.common.Resource
import com.example.rickandmortykotlin.presentation.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    protected open fun <T> MutableStateFlow<UIState<T>>.subscribeTo(
        request: () -> Flow<Resource<T>>,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            request().collect {
                when (it) {
                    is Resource.Loading -> {
                        this@subscribeTo.value = UIState.Loading()
                    }
                    is Resource.Error -> it.message?.let { error ->
                        this@subscribeTo.value = UIState.Error(error)
                    }
                    is Resource.Success -> it.data?.let { data ->
                        this@subscribeTo.value = UIState.Success(data)
                    }
                }


            }
        }
    }
}