package com.example.allen_calculator_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button

class MainActivity : AppCompatActivity() {
     var buttonCalc:Button ?=null
     var buttonWeb:Button ?=null
     var buttonIntent:Button ?=null

    override fun onCreate(savedInstanceState: Bundle?) {

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar()?.hide(); // hide the title bar
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalc=findViewById(R.id.button_calc)
        buttonWeb=findViewById(R.id.button_web)
        buttonIntent=findViewById(R.id.button_intent)

        buttonCalc!!.setOnClickListener{
            var calc=Intent(this, Calc_Activity::class.java)
            startActivity(calc)
        }

        buttonWeb!!.setOnClickListener{
            var web=Intent(this, web_activity::class.java)
            startActivity(web)
        }

        buttonIntent!!.setOnClickListener{
            var intent=Intent(this, Intent_activity::class.java)
            startActivity(intent)
        }
    }
}