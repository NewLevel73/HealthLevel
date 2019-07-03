package com.example.healthlevel.library

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("android:adapter")
fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    recyclerView.adapter = adapter
}

@BindingAdapter("android:layoutManager")
fun setLayoutManager(recyclerView: RecyclerView, layoutManager: LinearLayoutManager) {
    recyclerView.layoutManager = layoutManager
}

@BindingAdapter("android:enabled")
fun setEnabled(view: View, enabled: Boolean) {
    view.isEnabled = enabled
}