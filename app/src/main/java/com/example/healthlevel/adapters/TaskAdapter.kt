package com.example.healthlevel.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.healthlevel.R
import com.example.healthlevel.library.BindableViewHolder
import com.example.healthlevel.models.TaskObject
import com.example.healthlevel.databinding.TaskListItemBinding

class TaskAdapter: RecyclerView.Adapter<TaskHolder>(){
    var tasks: ArrayList<TaskObject> = arrayListOf()

    fun addTask(task: TaskObject) {
        val position = tasks.count()
        tasks.add(task)
        notifyItemChanged(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        return TaskHolder(parent)
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.setItem(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size
}

class TaskHolder(parent: ViewGroup)
    : BindableViewHolder<TaskListItemBinding>(R.layout.task_list_item, parent){
    fun setItem(item: TaskObject) {
        binding.model = item
    }
}