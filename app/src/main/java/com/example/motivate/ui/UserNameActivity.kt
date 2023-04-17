package com.example.motivate.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.motivate.infra.MotivationConstants
import com.example.motivate.R
import com.example.motivate.infra.SecurityPreferences
import com.example.motivate.databinding.ActivityUserNameBinding

class UserNameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserNameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonSave.setOnClickListener {
            handleSave()
        }

        verifyUserName()
    }

    private fun verifyUserName(){
        val userName = SecurityPreferences(this).getUserName(MotivationConstants.KEY.USER_NAME)
        if(userName != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun handleSave() {
        val name = binding.editYourName.text.toString()

        if (name != "") {

            SecurityPreferences(this).storeUserName(MotivationConstants.KEY.USER_NAME, name)

            val navigateToMain = Intent(this, MainActivity::class.java)
            startActivity(navigateToMain)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }
}