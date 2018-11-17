package com.example.ilteriskeskin.agnohesapla

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.yeni_ders_layout.view.*

class MainActivity : AppCompatActivity() {

    private var tumDerslerinBilgileri:ArrayList<Dersler> = ArrayList(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (rootLayout.childCount == 0) {
            btnHesapla.visibility = View.INVISIBLE
        } else {
            btnHesapla.visibility = View.VISIBLE
        }

        btnEkle.setOnClickListener {

            if (!etDersAd.text.isNullOrEmpty()) {

                var infilater = LayoutInflater.from(this)

                var yeniDersView = infilater.inflate(R.layout.yeni_ders_layout, null)

                var dersAdi = etDersAd.text.toString()
                var dersKredi = spnDersKredi.selectedItem.toString()
                var dersNot = spnDersNot.selectedItem.toString()

                yeniDersView.etYeniDersAd.setText(dersAdi)
                yeniDersView.spnYeniDersKredi.setSelection(spinnerIndex(spnDersKredi, dersKredi))
                yeniDersView.spnYeniDersNot.setSelection(spinnerIndex(spnDersNot, dersNot))

                yeniDersView.btnSil.setOnClickListener {
                    rootLayout.removeView(yeniDersView)

                    if (rootLayout.childCount == 0) {
                        btnHesapla.visibility = View.INVISIBLE
                    } else {
                        btnHesapla.visibility = View.VISIBLE
                    }
                }

                rootLayout.addView(yeniDersView)

                btnHesapla.visibility = View.VISIBLE

                sifirla()

            }
            else {
                Toast.makeText(this, "Ders Adını Giriniz!", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun ortalamaHesapla(view: View) {

        var toplamNot = 0.0
        var toplamKredi = 0.0

        for (i in 0..rootLayout.childCount - 1) {
            var tekSatir = rootLayout.getChildAt(i)
            var geciciDers = Dersler(tekSatir.etYeniDersAd.text.toString(),
                                    ((tekSatir.spnYeniDersKredi.selectedItemPosition) + 1).toString(),
                                    tekSatir.spnYeniDersNot.selectedItem.toString())

            tumDerslerinBilgileri.add(geciciDers)
        }

        for (oankiDers in tumDerslerinBilgileri) {
            toplamNot += harfNotunuCevir(oankiDers.dersNot) * (oankiDers.dersKredi.toDouble())
            toplamKredi += oankiDers.dersKredi.toDouble()
        }

        Toast.makeText(this, "Ortalama: " + (toplamNot / toplamKredi), Toast.LENGTH_LONG).show()

        tumDerslerinBilgileri.clear()
    }

    fun harfNotunuCevir(gelenNotHarf:String) : Double {
        var deger = 0.0

        when (gelenNotHarf) {
            "AA" -> deger = 4.0
            "BA" -> deger = 3.5
            "BB" -> deger = 3.0
            "CB" -> deger = 2.5
            "CC" -> deger = 2.0
            "DC" -> deger = 1.5
            "DD" -> deger = 1.0
            "FF" -> deger = 0.0
        }
        return deger
    }

    fun spinnerIndex(spinner: Spinner, aranacakDeger: String): Int {
        var index = 0

        for (i in 0..spinner.count) {
            if (spinner.getItemAtPosition(i).toString().equals(aranacakDeger)) {
                index = i
                break
            }
        }
        return index
    }

    fun sifirla() {
        etDersAd.setText("")
        spnDersKredi.setSelection(0)
        spnDersNot.setSelection(0)
    }
}
