package com.implude.niche.presentation.main.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.implude.niche.R
import com.implude.niche.databinding.ActivityCommentsMoreBinding
import com.implude.niche.databinding.ActivityHeartsMoreBinding

class HeartsMoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeartsMoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hearts_more)
        binding = ActivityHeartsMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goBackArrow.setOnClickListener {
            finish()
        }
    }
}