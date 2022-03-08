package com.example.rickandmortykotlin.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.rickandmortykotlin.common.Resource
import com.example.rickandmortykotlin.data.models.response.network.pagingsources.base.BasePagingSource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

abstract class BaseRepository {

    protected fun<T> doRequest(request:  () -> T) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data= request()))
        }catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?:"Error occurred!!")
            )
        }
    }
    protected fun <Value: Any> doPagingRequest(
        pagingSource: BasePagingSource<Value>,
        pageSize: Int = 10,
        prefetchDistance: Int = pageSize,
        enablePlaceholders: Boolean = true,
        initiaLoadSize : Int  = pageSize * 3,
        maxSize: Int = Int.MAX_VALUE,
        jumpThreshold: Int = Int.MIN_VALUE


    ): LiveData<PagingData<Value>> {
        return Pager(
            config = PagingConfig(
                pageSize,
                prefetchDistance,
                enablePlaceholders,
                initiaLoadSize,
                maxSize,
                jumpThreshold
            ),
            pagingSourceFactory = {
                pagingSource
            }
        ).liveData

    }
}
