package com.example.lab6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.lab6.databinding.ActivityMain2Binding
import com.example.lab6.databinding.ActivityMainBinding

class SecondActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMain2Binding

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.countView.text = "Счётчик: $count"

        binding.buttonPlusOne.setOnClickListener(){

            count++
            binding.countView.text = "Счётчик: $count"

        }

        binding.button.setOnClickListener() {

            startActivity(Intent(this, ThirdActivity::class.java).apply {
                putExtra("Count", count)
            })
        }

    }

}

