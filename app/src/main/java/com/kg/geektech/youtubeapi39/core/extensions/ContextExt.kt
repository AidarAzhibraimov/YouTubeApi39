package com.kg.geektech.youtubeapi39.core.extensions

import android.content.Context
import android.widget.Toast

fun Context.showToast(massage: String){
    Toast.makeText(this,massage,Toast.LENGTH_SHORT).show()
}
