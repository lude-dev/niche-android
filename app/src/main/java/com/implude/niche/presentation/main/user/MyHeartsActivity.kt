package com.implude.niche.presentation.main.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.implude.niche.R
import com.implude.niche.databinding.ActivityMyHeartsBinding

class MyHeartsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyHeartsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_hearts)
        binding = ActivityMyHeartsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goBackArrow.setOnClickListener {
            finish()
        }
    }
}