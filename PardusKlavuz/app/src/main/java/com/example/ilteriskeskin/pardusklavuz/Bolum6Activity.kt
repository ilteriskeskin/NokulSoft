package com.example.ilteriskeskin.pardusklavuz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class Bolum6Activity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bolum6)

        MobileAds.initialize(this, "ca-app-pub-7241074395795386~8115209929")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }

    fun geri(view: View) {
        val i = Intent(this, Bolum5Activity::class.java)
        startActivity(i)
    }

    fun ileri(view: View) {
        val i = Intent(this, SonActivity::class.java)
        startActivity(i)
    }

    fun home(view: View) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}
