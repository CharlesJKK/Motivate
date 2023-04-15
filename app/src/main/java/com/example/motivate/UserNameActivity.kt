package com.example.motivate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
    }

    private fun handleSave() {
        val name = binding.editYourName.text.toString()
        if (name != "") {
            val navigateToMain = Intent(this, MainActivity::class.java)
            startActivity(navigateToMain)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }
}