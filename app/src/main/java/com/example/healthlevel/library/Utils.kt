package com.example.healthlevel.library

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BindableViewHolder<TBinding : ViewDataBinding>( val binding: TBinding) : RecyclerView.ViewHolder(binding.root) {
    constructor(resId: Int, parent: ViewGroup) : this(DataBindingUtil.inflate(parent.getLayoutInflater(),
        resId, parent, false))
}

fun View.getLayoutInflater(): LayoutInflater {
    return this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
}

val Context.layoutInflater: LayoutInflater
    get() = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
