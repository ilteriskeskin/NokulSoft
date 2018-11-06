package com.example.ilteriskeskin.paradonustur

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, "ca-app-pub-7241074395795386~4018228413");

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

    fun getRates(view: View) {
        val download = Download()

        try {
            // val url = "http://data.fixer.io/api/latest?access_key=d3daeafbc6ce99bfb2693886267e4e3b&format=1"
            // val url = "https://api.exchangeratesapi.io/latest"
            val url = "https://api.exchangeratesapi.io/latest?base=USD"
            download.execute(url)

        } catch (e : Exception) {

        }
    }

    inner class Download : AsyncTask<String, Void, String>(){
        override fun doInBackground(vararg params: String?): String {
            var result = ""
            var url : URL
            var httpUrlConnection : HttpURLConnection

            try {
                url = URL(params[0])
                httpUrlConnection = url.openConnection() as HttpURLConnection
                val inputStream = httpUrlConnection.inputStream
                val inputStreamReader = InputStreamReader(inputStream)

                var data = inputStreamReader.read()

                while (data > 0) {
                    val character = data.toChar()
                    result += character

                    data = inputStreamReader.read()
                }
                return result

            } catch (e : Exception) {
                return result
            }

            return result
        }

        override fun onPostExecute(result: String?) {

            try {
                val jsonObject = JSONObject(result)
                //val base = jsonObject.getString("base")
                val rates = jsonObject.getString("rates")

                val jsonObject1 = JSONObject(rates)

                val a = jsonObject1.getString(spinner.selectedItem.toString())
                val b = jsonObject1.getString(spinner2.selectedItem.toString())

                var aFloat: Float = a.toFloat()
                var bFloat: Float = b.toFloat()

                val convert: Float = aFloat / bFloat
                val convertString: String = convert.toString()

                textView.text = "Dönüşüm: " + convertString



            } catch (e : Exception) {
                Toast.makeText(this@MainActivity, "Internetinizi açıp tekrar deneyiniz.", Toast.LENGTH_SHORT).show()            }

            super.onPostExecute(result)
        }

    }
}
