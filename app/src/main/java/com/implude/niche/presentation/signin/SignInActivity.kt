package com.implude.niche.presentation.signin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.implude.niche.R

class SignInActivity : AppCompatActivity() {

    private val signInViewModel by viewModels<SignInViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, EmailFragment()).commit()
    }
}