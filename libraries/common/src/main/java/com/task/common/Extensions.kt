package com.task.common

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

// load image from url or res id
fun ImageView.loadImage(url: Any?, placeHolderResId: Int) {
    url?.let {
        if (url is Int) {
            Picasso.get()
                .load(url)
                .placeholder(placeHolderResId)
                .into(this)

            setImageResource(url)
        }

        if (url is String)
            Picasso.get()
                .load(url)
                .into(this)
    }
}

// make view visible extension
fun View.visible() {
    visibility = View.VISIBLE
}

// make view gone extension
fun View.gone() {
    visibility = View.GONE
}


// open activity extension
fun Context.openActivity(className: Class<*>, bundle: Bundle? = null, closeAll: Boolean = false) {

    val intent = Intent(this, className)
    bundle?.let {
        intent.putExtras(it)
    }

    if (closeAll) {
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    }
    startActivity(intent)
}
