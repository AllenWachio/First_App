package com.example.allen_calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Calc_Activity : AppCompatActivity() {

    lateinit var buttonadd:Button
    lateinit var buttonsub:Button
    lateinit var buttondiv:Button
    lateinit var buttonmulti:Button
    lateinit var first_number:EditText
    lateinit var second_number:EditText
    lateinit var answer:TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar()?.hide(); // hide the title bar
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        super.onCreate(savedInstanceState)
        setContentView(R.layout.calc_activity)

        buttonadd = findViewById(R.id.add)
        buttonsub = findViewById(R.id.subtract)
        buttondiv = findViewById(R.id.divide)
        buttonmulti = findViewById(R.id.multiply)
        first_number = findViewById(R.id.firstnumber)
        second_number = findViewById(R.id.secondnumber)
        answer = findViewById(R.id.answer)

        buttonadd.setOnClickListener {
            var fnum = first_number.text.toString()
            var snum = second_number.text.toString()

            if (fnum.isEmpty() && snum.isEmpty()) {
                answer.text = "Please Enter Inputs In the Fields!!"
            } else {
                var Answer = fnum.toDouble() + snum.toDouble()
                answer.text = Answer.toString()
            }
        }
        buttonsub.setOnClickListener {
            var fnum = first_number.text.toString()
            var snum = second_number.text.toString()

            if (fnum.isEmpty() && snum.isEmpty()) {
                answer.text = "Please Enter Inputs In the Fields!!"
            } else {
                var Answer = fnum.toDouble() - snum.toDouble()
                answer.text = Answer.toString()
            }
        }
        buttondiv.setOnClickListener {
            var fnum = first_number.text.toString()
            var snum = second_number.text.toString()

            if (fnum.isEmpty() && snum.isEmpty()) {
                answer.text = "Please Enter Inputs In the Fields!!"
            } else {
                var Answer = fnum.toDouble() / snum.toDouble()
                answer.text = Answer.toString()
            }
        }
        buttonmulti.setOnClickListener {
            var fnum = first_number.text.toString()
            var snum = second_number.text.toString()

            if (fnum.isEmpty() && snum.isEmpty()) {
                answer.text = "Please Enter Inputs In the Fields!!"
            } else {
                var Answer = fnum.toDouble() * snum.toDouble()
                answer.text = Answer.toString()
            }
        }
    }
}