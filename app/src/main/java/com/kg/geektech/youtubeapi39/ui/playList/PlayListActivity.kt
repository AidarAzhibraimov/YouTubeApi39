package com.kg.geektech.youtubeapi39.ui.playList

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kg.geektech.youtubeapi39.NetworkConnection
import com.kg.geektech.youtubeapi39.base.BaseActivity
import com.kg.geektech.youtubeapi39.core.result.Status
import com.kg.geektech.youtubeapi39.databinding.ActivityPlaylistBinding
import com.kg.geektech.youtubeapi39.data.model.Playlist
import com.kg.geektech.youtubeapi39.ui.detail_playlist.DetailActivity


class PlaylistActivity : BaseActivity<PlayListViewModel, ActivityPlaylistBinding>() {

    companion object {
        const val ID = "id"
    }

    override val viewModel: PlayListViewModel by lazy {
        ViewModelProvider(this)[PlayListViewModel::class.java]
    }

    override fun initViewModel() {
        super.initViewModel()

        viewModel.loading.observe(this) {
            binding.progressBar.isVisible = it
        }
        viewModel.getPlaylist().observe(this) {
            when (it.status) {
                Status.LOADING -> viewModel.loading.postValue(true)
                Status.SUCCESS -> {
                    initRecycler(it.data)
                    viewModel.loading.postValue(false)
                }
                Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    viewModel.loading.postValue(false)
                }
            }
        }
        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this) { isConnected ->
            if (isConnected) {
                binding.apply {
                    recycler.visibility = View.VISIBLE
                    chekInternet.visibility = View.INVISIBLE
                }
            } else {
                binding.apply {
                    chekInternet.visibility = View.VISIBLE
                    recycler.visibility = View.INVISIBLE
                }

            }
        }
    }


    private fun initRecycler(playlist: Playlist?) {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = playlist?.items?.let { AdapterPlaylist(it, this::listener) }
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(inflater)
    }

    private fun listener(id: String) {
        Intent(this@PlaylistActivity, DetailActivity::class.java).apply {
            putExtra(ID, id)
            startActivity(this)
        }
    }



}