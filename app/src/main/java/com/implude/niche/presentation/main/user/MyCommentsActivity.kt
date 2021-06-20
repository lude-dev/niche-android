package com.implude.niche.presentation.main.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.implude.niche.R
import com.implude.niche.databinding.ActivityMyCommentsBinding

class MyCommentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyCommentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_comments)
        binding = ActivityMyCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goBackArrow.setOnClickListener {
            finish()
        }


    }
}