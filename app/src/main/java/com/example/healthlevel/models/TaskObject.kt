package com.example.healthlevel.models

import com.example.healthlevel.library.TaskRepeatTime
import com.example.healthlevel.library.TaskType

class TaskObject {

    var theme: String = ""
    var type: String = TaskType.List[0]
    var repeatTime: String = TaskRepeatTime.List[0]
}