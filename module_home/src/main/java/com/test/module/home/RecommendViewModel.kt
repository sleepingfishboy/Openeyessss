package com.test.module.home

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.test.module.home.network.ApiManager
import kotlinx.coroutines.flow.Flow

class RecommendViewModel : ViewModel() {
    fun getPagingData():Flow<PagingData<AllRec.Item>>{
        return ApiManager.getPagingData().cachedIn(viewModelScope)
    }
}

