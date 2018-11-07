package com.example.ilteriskeskin.pardusklavuz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, "ca-app-pub-7241074395795386~8115209929")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
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
