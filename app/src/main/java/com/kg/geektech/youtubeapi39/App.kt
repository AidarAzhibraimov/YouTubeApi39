package com.kg.geektech.youtubeapi39

import android.app.Application
import com.kg.geektech.youtubeapi39.repository.Repository

class App: Application() {
    val repository: Repository by lazy {
        Repository()
    }
}