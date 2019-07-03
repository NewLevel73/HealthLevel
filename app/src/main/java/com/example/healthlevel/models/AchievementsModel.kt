package com.example.healthlevel.models

import android.content.Context
import com.example.healthlevel.library.getStandardGetterDialog

class AchievementsModel {

    private val achievementsThemeText = arrayOf("Покоритель вершин", "Кто рано встает", "Первый прием",
        "Вакцинатор", "Охотник за звездами", "Победитель по жизни")
    private val achievementsText = arrayOf("Выполнение всех заданий в течение года",
        "Соблюдение распорядка сна в течение недели",
        "Прохождение первого медицинского осмотра через приложение",
        "Вакцинация в течение года",
        "Добавление 100 заданий",
        "Достижение всех достижений")
    private var main: Context? = null

    var closeListener: (() -> Unit)? = null

    fun a1Click() {
        showAchievementsDialog(0)
    }

    fun a2Click() {
        showAchievementsDialog(1)
    }

    fun a3Click() {
        showAchievementsDialog(2)
    }

    fun a4Click() {
        showAchievementsDialog(3)
    }

    fun a5Click() {
        showAchievementsDialog(4)
    }

    fun a6Click() {
        showAchievementsDialog(5)
    }

    fun onCloseClick() {
        closeListener?.invoke()
    }

    private fun showAchievementsDialog(position: Int) {
        val context = main
        if (context != null) {
            getStandardGetterDialog(context, achievementsThemeText[position], achievementsText[position] ).show()
        }
    }

    fun setContext(context: Context) {
        main = context
    }
}