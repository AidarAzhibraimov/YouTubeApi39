package com.kg.geektech.youtubeapi39.ui.playList

import androidx.lifecycle.LiveData
import com.kg.geektech.youtubeapi39.App
import com.kg.geektech.youtubeapi39.base.BaseViewModel
import com.kg.geektech.youtubeapi39.core.result.Resource
import com.kg.geektech.youtubeapi39.data.model.Playlist

class PlayListViewModel: BaseViewModel() {
    fun getPlaylist(): LiveData<Resource<Playlist>> {
        return App().repository.getPlaylists()
    }
}