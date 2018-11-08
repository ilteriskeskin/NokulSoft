package com.example.ilteriskeskin.pardusklavuz

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class SonActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_son)

        MobileAds.initialize(this, "ca-app-pub-7241074395795386~8115209929")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }

    fun site(view: View) {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nokulsoft.com"))
        startActivity(i)
    }
}
