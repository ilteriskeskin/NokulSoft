package com.example.ilteriskeskin.troll

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    var sayac = 0

    fun clickButton(view: View) {
        sayac += 1

        Toast.makeText(this, "Bana tıklama! " + sayac, Toast.LENGTH_SHORT).show()

        if (sayac == 10) {
            imageView.visibility = View.VISIBLE
        }

        if (sayac == 20) {
            imageView.visibility = View.INVISIBLE
        }

        if (sayac == 27) {
            Toast.makeText(this, "Sürpriz mi istiyorsun?", Toast.LENGTH_SHORT).show()
        }

        if (sayac == 33) {
            imageView2.visibility = View.VISIBLE
        }

        if (sayac == 41) {
            imageView2.visibility = View.INVISIBLE
        }

        if (sayac == 43) {
            Toast.makeText(this, "Her şey bitti!", Toast.LENGTH_LONG).show()
            Thread.sleep(2000)
            System.exit(0)
        }
    }
}
