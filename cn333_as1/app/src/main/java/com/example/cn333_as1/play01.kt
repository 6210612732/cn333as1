package com.example.cn333_as1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class play01 : AppCompatActivity() {
    var MaxShow: TextView? = null
    var MinShow: TextView? = null
    var input_num: EditText? = null
    var bt_confirm: Button? = null
    var message: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play01)
        MaxShow =  findViewById(R.id.MaxShow) as TextView
        MinShow =  findViewById(R.id.MinShow) as TextView
        message =  findViewById(R.id.mes) as TextView
        var intent = intent
        var maxn: Int = intent.getStringExtra("Max").toString().toInt()
        var minn: Int = intent.getStringExtra("Min").toString().toInt()
        var randomn: Int = intent.getStringExtra("Random").toString().toInt()
        var inputn: Int = intent.getStringExtra("Input").toString().toInt()
        var guess: Int = intent.getStringExtra("guess").toString().toInt()


        if(inputn == -1){
            message!!.text = "Start"
        }
        else{
            message!!.text = "Please input number"
        }
        if(inputn < randomn && inputn != -1){
            message!!.text = "it's higher"
            if(minn < inputn)
                minn = inputn
        }
        if(randomn < inputn){
            message!!.text = "it's lower"
            if(inputn < maxn)
                maxn = inputn
        }
        if(randomn == inputn){
            val intent2 = Intent(this,end::class.java)
            intent2.putExtra("Answer",randomn.toString())
            intent2.putExtra("guess",guess.toString())
            startActivity(intent2)
        }

        MaxShow!!.text = maxn.toString()
        MinShow!!.text = minn.toString()
        //MaxShow!!.text = randomn.toString()
        //MinShow!!.text = inputn.toString()

        input_num = findViewById(R.id.input_num) as EditText
        bt_confirm = findViewById(R.id.bt_cf) as Button

        bt_confirm!!.setOnClickListener{
            val intent = Intent(this,play01::class.java)
            intent.putExtra("Max",maxn.toString())
            intent.putExtra("Min",minn.toString())
            intent.putExtra("Random",randomn.toString())
            intent.putExtra("Input",input_num!!.text.toString())
            intent.putExtra("guess",(guess+1).toString())
            startActivity(intent)
        }
    }
}
