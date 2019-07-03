package com.example.healthlevel.models

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthlevel.adapters.TaskAdapter

class MainMenuModel {

    var adapter = TaskAdapter()
    var layoutManager: LinearLayoutManager? = null
    private var createTaskListener: (() -> Unit)? = null
    private var openAchievementsListener: (() -> Unit)? = null

    fun setTask(task: TaskObject) {
        adapter.addTask(task)
    }

    fun init(context:Context) {
        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }

    fun initListeners(createListener: () -> Unit, openAchievementsListener: () -> Unit) {
        createTaskListener = createListener
        this.openAchievementsListener = openAchievementsListener
    }

    fun createTaskClick(){
        createTaskListener?.invoke()
    }

    fun openAchievementsClick(){
        openAchievementsListener?.invoke()
    }
}