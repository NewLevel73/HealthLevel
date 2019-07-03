package com.example.healthlevel.models

import android.content.Context
import androidx.databinding.ObservableField
import com.example.healthlevel.R
import com.example.healthlevel.library.TaskRepeatTime
import com.example.healthlevel.library.TaskType
import com.example.healthlevel.library.getStandardListDialog

class CreateTaskModel {

    var taskThemeText: String = ""
    var taskTypeText = ObservableField<String>(TaskType.List[0])
    var taskRepeatTimeText = ObservableField<String>(TaskRepeatTime.List[0])

    var taskTypeListener: (() -> Unit)? = null
    var taskRepeatTimeListener: (() -> Unit)? = null
    var saveButtonListener: (() -> Unit)? = null
    var closeButtonListener: (() -> Unit)? = null

    fun initListeners(context: Context, saveListener: () -> Unit, closeListener: () -> Unit) {
        initTaskDialog(context)
        saveButtonListener = saveListener
        closeButtonListener = closeListener
    }

    fun getTask(): TaskObject = TaskObject().apply {
        theme = taskThemeText
        type = taskTypeText.get() ?: ""
        repeatTime = taskRepeatTimeText.get() ?: ""
    }

    fun taskTypeClick() {
        taskTypeListener?.invoke()
    }

    fun taskRepeatTimeClick() {
        taskRepeatTimeListener?.invoke()
    }

    fun saveButtonClick() {
        saveButtonListener?.invoke()
    }

    fun closeButtonClick() {
        closeButtonListener?.invoke()
    }

    private fun initTaskDialog(context: Context) {
        val taskTypeDialog = getStandardListDialog(context, TaskType.List, context.getString(R.string.task_type)) {dialog, position ->
            taskTypeText.set(TaskType.List[position])
            dialog.dismiss()
        }
        val taskRepeatTimeDialog = getStandardListDialog(context, TaskRepeatTime.List, context.getString(R.string.repeat_time)) {dialog, position ->
            taskRepeatTimeText.set(TaskRepeatTime.List[position])
            dialog.dismiss()
        }
        taskTypeListener = {
            taskTypeDialog.show()
        }
        taskRepeatTimeListener = {
            taskRepeatTimeDialog.show()
        }
    }
}