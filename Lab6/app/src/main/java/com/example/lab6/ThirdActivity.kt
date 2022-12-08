package com.example.lab6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.lab6.databinding.ActivityMain2Binding
import com.example.lab6.databinding.ActivityMain3Binding
import com.example.lab6.databinding.ActivityMainBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener() {
            val intentCountClass = intent.getIntExtra("Count",0)
            intentCountClass?.let{
                binding.countView.text = "Счётчик: $intentCountClass"
            }
        }

        }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.apply{
            putString("save_count",  binding.countView.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.run{
            val saveString = getString("save_count")
            binding.countView.text = saveString
        }
    }

}

