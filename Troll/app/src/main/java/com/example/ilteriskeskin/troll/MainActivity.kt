package com.example.ilteriskeskin.troll

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, "ca-app-pub-7241074395795386~4696029038")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }

    var sayac = 0

    fun clickButton(view: View) {
        sayac += 1

        if (sayac >= 1 && sayac <= 14) {
            Toast.makeText(this, "Bana tıklama! " + sayac, Toast.LENGTH_SHORT).show()
        }

        if (sayac >= 15 && sayac <= 32) {
            imageView.visibility = View.VISIBLE
            Toast.makeText(this, "Fotoğrafa iyi bak. " + sayac, Toast.LENGTH_SHORT).show()
        }

        if (sayac >= 33 && sayac <= 41) {
            imageView.visibility = View.INVISIBLE
            Toast.makeText(this, "Kediyi sevdiysen biraz daha tıkla madem " + sayac, Toast.LENGTH_SHORT).show()
        }

        if (sayac >= 42 && sayac <= 55) {
            Toast.makeText(this, "Sürpriz mi istiyorsun?" + sayac, Toast.LENGTH_SHORT).show()
        }

        if (sayac >= 56 && sayac <= 64) {
            imageView2.visibility = View.VISIBLE
            Toast.makeText(this, "Fazla uzun sürmeyecek... " + sayac, Toast.LENGTH_SHORT).show()
        }

        if (sayac >= 65 && sayac <= 74) {
            imageView2.visibility = View.INVISIBLE
            Toast.makeText(this, "Biraz sakin ol, bir şeyleri kaçıracaksın" + sayac, Toast.LENGTH_SHORT).show()
        }

        if (sayac >= 75 && sayac <= 84) {
            Toast.makeText(this, "Her şey bitti, yakında daha uzun görüşeceğiz", Toast.LENGTH_LONG).show()
        }
        if (sayac == 85) {
            Thread.sleep(2000)
            System.exit(0)
        }
    }
}
