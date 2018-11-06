package com.example.ilteriskeskin.pardusklavuz

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

    }

    fun site(view: View) {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nokulsoft.com"))
        startActivity(i)
    }

}