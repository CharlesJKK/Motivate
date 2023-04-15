package com.example.motivate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        handleUserName()

        binding.buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_new_phrase){

        }
    }

    private fun handleUserName(){
        val userName = SecurityPreferences(this).getUserName("USER_NAME")
        binding.textUserName.text = "Olá, $userName!"
    }
}