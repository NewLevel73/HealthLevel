package com.example.healthlevel.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.healthlevel.R
import com.example.healthlevel.databinding.CreateTaskBinding
import com.example.healthlevel.library.CREATE_TASK_EXTRA
import com.example.healthlevel.library.CREATE_TASK_REQUEST_CODE
import com.example.healthlevel.models.CreateTaskModel
import com.google.gson.Gson

class CreateTaskActivity : AppCompatActivity() {

    val model = CreateTaskModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<CreateTaskBinding>(this, R.layout.create_task)

        model.initListeners(this, {
            val intent = Intent()
            intent.putExtra(CREATE_TASK_EXTRA, Gson().toJson(model.getTask()))
            setResult(CREATE_TASK_REQUEST_CODE, intent)
            finish()
        }, {
            finish()
        })

        binding.model = model
    }
}
