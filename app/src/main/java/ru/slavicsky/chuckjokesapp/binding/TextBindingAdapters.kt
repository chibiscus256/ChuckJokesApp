package ru.slavicsky.chuckjokesapp.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter

object TextBindingAdapters {
    @JvmStatic
    @BindingAdapter("android:text")
    fun bindText(view: TextView, value: Int) {
        view.text = value.toString()
    }
}