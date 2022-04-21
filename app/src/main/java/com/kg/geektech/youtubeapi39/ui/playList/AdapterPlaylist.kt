package com.kg.geektech.youtubeapi39.ui.playList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kg.geektech.youtubeapi39.R
import com.kg.geektech.youtubeapi39.databinding.ItemPlaylistBinding
import com.kg.geektech.youtubeapi39.core.extensions.loadImg
import com.kg.geektech.youtubeapi39.data.model.Items

class AdapterPlaylist(private val playlist: List<Items>, private val onClick: (id: String) -> Unit) :
    RecyclerView.Adapter<AdapterPlaylist.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playlist[position])
    }

    override fun getItemCount(): Int {
        return playlist.size
    }

    inner class ViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(items: Items) {
            binding.apply {
                tvVideo.text = String.format(itemView.context.getString(R.string.video), items.contentDetails.itemCount.toString())
                tvPlaylistName.text = items.snippet.title
                ivPlaylist1.loadImg(items.snippet.thumbnails.high.url)
                tvPlaylist.text = items.snippet.channelTitle
                itemView.setOnClickListener {
                    onClick(items.id)
                }
            }
        }
    }
}