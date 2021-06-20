package com.implude.niche.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.implude.niche.R
import com.implude.niche.databinding.ActivityEditStoreInfoBinding

class EditStoreInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditStoreInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_store_info)
        binding = ActivityEditStoreInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goBackArrow.setOnClickListener {
            finish()
        }

    }
}