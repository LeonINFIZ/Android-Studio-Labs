package com.lab5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintSet
import com.lab5.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit
import java.util.Timer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var numOnClick = 0

        binding.textView.text="Нажатий на кнопку: $numOnClick"

        val timer = object: CountDownTimer(20000, 10) {
            override fun onTick(millisUntilFinished: Long) {
                numOnClick++
                binding.textView.text="Нажатий на кнопку: $numOnClick"
            }

            override fun onFinish() {}
        }

        fun String.toColor(): Int = Color.parseColor(this)

        val timer2 = object: CountDownTimer(700, 700) {
            override fun onTick(millisUntilFinished: Long) {
                binding.textViewRestart.setTextColor("#00ff00".toColor())
            }

            override fun onFinish() {
                binding.textView.text="Нажатий на кнопку: $numOnClick"
                binding.textViewRestart.setTextColor("#ff0000".toColor())
            }
        }



        binding.textViewRestart.setTextColor("#ff0000".toColor())

        binding.textViewRestart.setOnClickListener(){
            numOnClick=0

            timer2.start()








        }


        binding.button.setOnClickListener(){
            numOnClick++
            binding.textView.text="Нажатий на кнопку: $numOnClick"


        }

        binding.buttonPressed.setOnLongClickListener(){
            timer.start()
            true
        }

         binding.buttonPressed.setOnTouchListener(object : View.OnTouchListener {
             override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                 when (event?.action) {
                     MotionEvent.ACTION_UP ->  timer.cancel()
                 }

                 return v?.onTouchEvent(event) ?: true
             }
         })



        }

}





