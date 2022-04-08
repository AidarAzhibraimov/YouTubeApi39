package com.kg.geektech.youtubeapi39.ui.playList

import android.view.LayoutInflater
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kg.geektech.youtubeapi39.base.BaseActivity
import com.kg.geektech.youtubeapi39.databinding.ActivityPlaylistBinding
import com.kg.geektech.youtubeapi39.extensions.showToast
import com.kg.geektech.youtubeapi39.model.Items
import com.kg.geektech.youtubeapi39.model.Playlist

class PlayListActivity : BaseActivity<PlayListViewModel,ActivityPlaylistBinding>() {


    private lateinit var  adapter : AdapterPlaylist


    override val viewModel: PlayListViewModel by lazy {
        ViewModelProvider(this)[PlayListViewModel::class.java]
    }

    override fun initView() {
        super.initView()
        binding.recycler.layoutManager=LinearLayoutManager(this)
        binding.recycler.adapter = adapter

    }

    override fun initViewModel() {
        super.initViewModel()

        viewModel.getPlaylist().observe(this){
            showToast(it.kind.toString())
        }
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(inflater)
    }


}