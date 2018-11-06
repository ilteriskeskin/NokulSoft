package com.example.ilteriskeskin.pardusklavuz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view:View) {
        val intent = Intent(this, ContentActivity::class.java)
        startActivity(intent)
    }

    fun about(view:View) {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }
}
