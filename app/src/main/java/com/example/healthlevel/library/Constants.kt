package com.example.healthlevel.library

const val CREATE_TASK_REQUEST_CODE = 10
const val CREATE_TASK_EXTRA = "create_task"

object TaskType {
    private const val Active: String = "Активность"
    private const val Reminder: String = "Напоминание"
    private const val Specialists: String = "Специалисты"
    val List = arrayOf(Active, Reminder, Specialists)
}

object TaskRepeatTime {
    private const val Once: String = "Единожды"
    private const val EveryDay: String = "Каждый день"
    private const val EveryOtherDay: String = "Через день"
    private const val OnceInWeek: String = "Раз в неделю"
    private const val OnceInMonth: String = "Раз в месяц"
    val List = arrayOf(Once, EveryDay, EveryOtherDay, OnceInWeek, OnceInMonth)
}