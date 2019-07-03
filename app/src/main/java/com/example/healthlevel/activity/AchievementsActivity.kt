package com.example.healthlevel.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.healthlevel.databinding.AchievementsBinding
import com.example.healthlevel.R
import com.example.healthlevel.models.AchievementsModel

class AchievementsActivity : AppCompatActivity() {

    private val model = AchievementsModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<AchievementsBinding>(this, R.layout.achievements)

        model.closeListener =  { finish() }
        model.setContext(this)

        binding.model = model
    }
}
