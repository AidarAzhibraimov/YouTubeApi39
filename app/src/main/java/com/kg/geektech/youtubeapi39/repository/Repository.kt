package com.kg.geektech.youtubeapi39.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kg.geektech.youtubeapi39.BuildConfig
import com.kg.geektech.youtubeapi39.core.result.Resource
import com.kg.geektech.youtubeapi39.data.model.Playlist
import com.kg.geektech.youtubeapi39.utils.Constant
import com.kg.geektech.youtubeapi39.data.remote.ApiService
import com.kg.geektech.youtubeapi39.core.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylists(): LiveData<Resource<Playlist>> {
        val data = MutableLiveData<Resource<Playlist>>()
        data.value = Resource.loading()
        apiService.getPlaylists(
            Constant.part,
            Constant.channelId,
            BuildConfig.API_KEY,
            Constant.maxResult
        )
            .enqueue(object : Callback<Playlist> {
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful) {
                        data.value = Resource.success(response.body())
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    data.value = Resource.error(t.message)
                }
            })
        return data
    }
}