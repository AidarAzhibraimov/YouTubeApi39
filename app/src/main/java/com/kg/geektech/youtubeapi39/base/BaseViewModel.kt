package com.kg.geektech.youtubeapi39.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {
    val loading = MutableLiveData<Boolean>()
}