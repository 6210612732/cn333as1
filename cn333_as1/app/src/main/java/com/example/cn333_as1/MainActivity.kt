package com.example.cn333_as1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var play_button: Button? = null
    val rand = (0..1000).random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play_button = findViewById(R.id.play_bt) as Button

        play_button!!.setOnClickListener{
            val intent = Intent(this,play01::class.java)
            intent.putExtra("Max","1000")
            intent.putExtra("Min","0")
            intent.putExtra("Random",rand.toString())
            intent.putExtra("Input","-1")
            intent.putExtra("guess","0")
            startActivity(intent)
        }
    }
}