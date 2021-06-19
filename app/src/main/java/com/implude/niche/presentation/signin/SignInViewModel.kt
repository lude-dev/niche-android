package com.implude.niche.presentation.signin

import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {

    var email: String = ""
    var password: String = ""
    var passwordVerify: String = ""

    fun checkEmailRegistered() {
        // temporary solution
    }
}