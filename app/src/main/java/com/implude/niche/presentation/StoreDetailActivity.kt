package com.implude.niche.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.implude.niche.R
import com.implude.niche.databinding.ActivityStoreDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class StoreDetailActivity : AppCompatActivity() {

    private val storeDetailViewModel: StoreDetailViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityStoreDetailBinding.inflate(layoutInflater)
        intent.getStringExtra(EXTRA_PLACE_ID)?.let { placeId ->
            storeDetailViewModel.fetchPlaceById(placeId)
        } ?: storeDetailViewModel.fetchPlaceById("60c45bf4aa6e01000fbe35fe")

        storeDetailViewModel.place.observe(this) {

            binding.data = it
            it.place?.tags?.filterNotNull()?.forEach { tag ->
                binding.storeTagsWrapper.addView(
                    TextView(binding.root.context).apply {
                        text = getString(R.string.tag_placeholder).format(tag.label)
                        background = ContextCompat.getDrawable(
                            binding.root.context,
                            R.drawable.tag_border
                        )
                        setTextColor(0xff323232.toInt())
                        typeface = ResourcesCompat.getFont(binding.root.context, R.font.noto_sans_kr_medium)
                    }
                )
            }
        }

        setContentView(binding.root)
    }

    companion object {
        const val EXTRA_PLACE_ID = "com.implude.niche.presentation.EXTRA_PLACE_ID"
        const val TAG = "StoreDetailActivity"
    }
}