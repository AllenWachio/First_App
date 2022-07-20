package com.example.allen_calculator_app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class web_activity : AppCompatActivity() {

    lateinit var web_view:WebView
    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar()?.hide(); // hide the title bar
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        web_view=findViewById(R.id.web_ig)
        webView()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webView(){
        web_view.webViewClient= WebViewClient()
        web_view.apply {
            loadUrl("https://www.instagram.com/")
            settings.safeBrowsingEnabled=true
            settings.javaScriptEnabled=true

        }
    }

    override fun onBackPressed() {
        if(web_view.canGoBack())web_view.goBack() else
            super.onBackPressed()
    }

}