package com.example.ilteriskeskin.pardusklavuz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class ContentActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        MobileAds.initialize(this, "ca-app-pub-7241074395795386~8115209929")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

    fun geri(view: View) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    fun ileri(view: View) {
        val i = Intent(this, Bolum1Activity::class.java)
        startActivity(i)
    }

    fun home(view: View) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    fun bolum1(view: View) {
        val i = Intent(this, Bolum1Activity::class.java)
        startActivity(i)
    }

    fun bolum2(view: View) {
        val i = Intent(this, Bolum2Activity::class.java)
        startActivity(i)
    }

    fun bolum3(view: View) {
        val i = Intent(this, Bolum3Activity::class.java)
        startActivity(i)
    }

    fun bolum4(view: View) {
        val i = Intent(this, Bolum4Activity::class.java)
        startActivity(i)
    }
    fun bolum5(view: View) {
        val i = Intent(this, Bolum5Activity::class.java)
        startActivity(i)
    }
    fun bolum6(view: View) {
        val i = Intent(this, Bolum6Activity::class.java)
        startActivity(i)
    }
}
