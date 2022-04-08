package com.kg.geektech.youtubeapi39.ui.playList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kg.geektech.youtubeapi39.databinding.ItemPlaylistBinding
import com.kg.geektech.youtubeapi39.extensions.loadImg
import com.kg.geektech.youtubeapi39.model.Items

class AdapterPlaylist : RecyclerView.Adapter<AdapterPlaylist.PlaylistHolder>() {
    private lateinit var list: List<Items>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterPlaylist.PlaylistHolder {
        val binding = ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PlaylistHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterPlaylist.PlaylistHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class PlaylistHolder(private val binding: ItemPlaylistBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Items) {
            binding.ivPlaylist.loadImg(items.snippet.thumbnails.high.url)
            binding.tvPlaylist.text = items.snippet.channelTitle
            binding.tvPlaylistName.text = items.snippet.title
        }

    }
}
