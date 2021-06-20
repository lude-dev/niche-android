package com.implude.niche.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.implude.niche.R
import com.implude.niche.databinding.ActivityEditStoreInfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditStoreInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditStoreInfoBinding
    private val addViewModel: StoreAddViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_store_info)
        binding = ActivityEditStoreInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val placeId = intent.getStringExtra(EXTRA_PLACE_ID)

        placeId?.let {
            addViewModel.fetchStore(placeId)
        }

        binding.goBackArrow.setOnClickListener {
            finish()
        }

    }

    companion object {
        const val EXTRA_PLACE_ID = "com.implude.niche.presentation.EXTRA_PLACE_ID"
    }
}