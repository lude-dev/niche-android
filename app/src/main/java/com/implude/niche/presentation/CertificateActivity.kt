package com.implude.niche.presentation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.core.content.ContextCompat
import com.bumptech.glide.load.model.ByteArrayLoader
import com.implude.niche.R
import com.implude.niche.databinding.ActivityCertificateBinding
import okhttp3.ResponseBody
import java.lang.reflect.Type

class CertificateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCertificateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certificate)
        binding = ActivityCertificateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.certNumberEdittext.addTextChangedListener(textWatcher)
        binding.taxTypeEdittext.addTextChangedListener(textWatcher)
        binding.businessConditionEdittext.addTextChangedListener(textWatcher)
        binding.itemEdittext.addTextChangedListener(textWatcher)
        binding.nameEdittext.addTextChangedListener(textWatcher)
        binding.ceoTypeEdittext.addTextChangedListener(textWatcher)
        binding.ceoNameEdittext.addTextChangedListener(textWatcher)
        binding.ceoBirthEdittext.addTextChangedListener(textWatcher)
        binding.addressEdittext.addTextChangedListener(textWatcher)
        binding.certImage.addTextChangedListener(textWatcher)
    }

    private var textWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            if (
                TextUtils.isEmpty(binding.certNumberEdittext.text) ||
                TextUtils.isEmpty(binding.taxTypeEdittext.text) ||
                TextUtils.isEmpty(binding.businessConditionEdittext.text) ||
                TextUtils.isEmpty(binding.itemEdittext.text) ||
                TextUtils.isEmpty(binding.nameEdittext.text) ||
                TextUtils.isEmpty(binding.ceoTypeEdittext.text) ||
                TextUtils.isEmpty(binding.ceoNameEdittext.text) ||
                TextUtils.isEmpty(binding.ceoBirthEdittext.text) ||
                TextUtils.isEmpty(binding.addressEdittext.text) ||
                TextUtils.isEmpty(binding.certImage.text)
            ) {
                binding.button.background = ContextCompat.getDrawable(this@CertificateActivity, R.drawable.button_disable)
                binding.button.setTextColor(ContextCompat.getColor(this@CertificateActivity, R.color.aquamarine))
            } else {
                binding.button.background = ContextCompat.getDrawable(this@CertificateActivity, R.drawable.button_enable)
                binding.button.setTextColor(ContextCompat.getColor(this@CertificateActivity, R.color.white))
            }
        }

        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int,
            after: Int
        ) {
        }

        override fun afterTextChanged(s: Editable) {
        }
    }

}