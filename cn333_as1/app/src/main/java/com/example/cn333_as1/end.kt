package com.example.cn333_as1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class end : AppCompatActivity() {
    var Answer: TextView? = null
    var guess: TextView? = null
    var new_bt: Button? = null
    val rand = (0..1000).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        Answer =  findViewById(R.id.answer) as TextView
        new_bt =  findViewById(R.id.new_bt) as Button
        guess =  findViewById(R.id.guess) as TextView
        var intent = intent
        Answer!!.text = intent.getStringExtra("Answer").toString()
        guess!!.text = intent.getStringExtra("guess").toString()
        new_bt!!.setOnClickListener{
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