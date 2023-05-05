package com.nurlanamirzayeva.quizthecountry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nurlanamirzayeva.quizthecountry.databinding.ActivityFirtstBinding


class FirstActivity : AppCompatActivity() {
    lateinit var binding: ActivityFirtstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirtstBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
        setUpListeners()

    }

    fun setUpListeners() {

        binding.firstbtn1.setOnClickListener {
             val mainPage = Intent(this, MainActivity::class.java)
             startActivity(mainPage)
        }

        binding.firstbtn2.setOnClickListener {

            val mainPage2= Intent(this, MainActivity2::class.java)
            startActivity(mainPage2)
        }

    }
}