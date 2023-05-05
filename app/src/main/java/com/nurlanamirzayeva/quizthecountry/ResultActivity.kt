package com.nurlanamirzayeva.quizthecountry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nurlanamirzayeva.quizthecountry.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0)
        binding.scoreLabel.text = getString(R.string.result_score, score)
        binding.tryAgainBtn.setOnClickListener {
             startActivity(Intent(this,FirstActivity::class.java))
        }
    }
}