package com.example.allen_calculator_app

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class Intent_activity : AppCompatActivity() {

    lateinit var buttonMpesa:Button
    lateinit var buttonShare:Button
    lateinit var buttonSms:Button
    lateinit var buttonCall:Button
    lateinit var buttonCamera:Button
    lateinit var buttonEmail:Button
    lateinit var buttonDial:Button

    override fun onCreate(savedInstanceState: Bundle?) {

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar()?.hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        buttonMpesa=findViewById(R.id.button_mpesa)
        buttonShare=findViewById(R.id.button_share)
        buttonSms=findViewById(R.id.button_sms)
        buttonCall=findViewById(R.id.button_call)
        buttonCamera=findViewById(R.id.button_camera)
        buttonEmail=findViewById(R.id.button_email)
        buttonDial=findViewById(R.id.button_dial)

        buttonSms.setOnClickListener{
            val uri = Uri.parse("sendto:0789876765")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("i.Hope you are having a great day!!", "The SMS text")
            startActivity(intent)
        }

        buttonCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254717419406"))

            if (ContextCompat.checkSelfPermission(
                    this@Intent_activity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@Intent_activity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }

        buttonMpesa.setOnClickListener {
            val simToolKitLaunchIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }

        buttonShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)
        }

        buttonEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "allenkizito9090@outlook.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }

        buttonCamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }

        buttonDial.setOnClickListener {
            val phone = ""
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)

        }

    }
}