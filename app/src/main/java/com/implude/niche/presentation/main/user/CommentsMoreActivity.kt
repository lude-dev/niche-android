package com.implude.niche.presentation.main.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.implude.niche.R
import com.implude.niche.databinding.ActivityCertificateBinding
import com.implude.niche.databinding.ActivityCommentsMoreBinding

class CommentsMoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCommentsMoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments_more)
        binding = ActivityCommentsMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goBackArrow.setOnClickListener {
            finish()
        }


    }
}