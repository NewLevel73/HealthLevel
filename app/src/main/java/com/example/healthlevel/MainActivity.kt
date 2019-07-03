package com.example.healthlevel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.healthlevel.activity.AchievementsActivity
import com.example.healthlevel.activity.CreateTaskActivity
import com.example.healthlevel.databinding.MainMenuBinding
import com.example.healthlevel.library.CREATE_TASK_EXTRA
import com.example.healthlevel.library.CREATE_TASK_REQUEST_CODE
import com.example.healthlevel.models.MainMenuModel
import com.example.healthlevel.models.TaskObject
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private val model = MainMenuModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<MainMenuBinding>(this, R.layout.main_menu)

        model.init(this)
        model.initListeners({ startActivityForCreatingTask() }, { startActivityForAchievements() })

        binding.model = model
    }

    private fun startActivityForCreatingTask() {
        val intent = Intent(this, CreateTaskActivity::class.java)
        startActivityForResult(intent, CREATE_TASK_REQUEST_CODE)
    }

    private fun startActivityForAchievements() {
        val intent = Intent(this, AchievementsActivity::class.java)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CREATE_TASK_REQUEST_CODE && data != null) {
            val task = data.getStringExtra(CREATE_TASK_EXTRA)
            model.setTask(Gson().fromJson(task, TaskObject::class.java))
        }
    }
}
