package com.kg.geektech.youtubeapi39.ui.playList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kg.geektech.youtubeapi39.BuildConfig.API_KEY
import com.kg.geektech.youtubeapi39.base.BaseViewModel
import com.kg.geektech.youtubeapi39.model.Playlist
import com.kg.geektech.youtubeapi39.objekt.Constant
import com.kg.geektech.youtubeapi39.remote.ApiService
import com.kg.geektech.youtubeapi39.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class PlayListViewModel: BaseViewModel() {

    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylist(): LiveData<Playlist> {
        return playlist()
    }

    private fun playlist(): LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()

        apiService.getPlaylists(Constant.part,Constant.channelId,API_KEY)
            .enqueue(object : retrofit2.Callback<Playlist> {
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful){
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    print(t.stackTrace)
                }

            })
        return data
    }
}