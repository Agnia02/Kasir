package com.example.amelp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaPembeli = findViewById<EditText>(R.id.txtNamaPembeli)
        val namaBarang = findViewById<EditText>(R.id.txtNamaBarang)
        val jumlahBeli = findViewById<EditText>(R.id.txtJumlahBeli)
        val harga = findViewById<EditText>(R.id.txtHarga)
        val uangbayar = findViewById<EditText>(R.id.txtUangBayar)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val totalBelanja = findViewById<TextView>(R.id.txtTotalBelanja)
        val kembalian = findViewById<TextView>(R.id.txtUangKembalian)
        val bonus = findViewById<TextView>(R.id.txtBonus)
        val keterangan = findViewById<TextView>(R.id.txtKeterangan)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnProses.setOnClickListener {
            var total: Int = 0
            val jmlBeli = Integer.parseInt(jumlahBeli.text.toString())
            var hrg = Integer.parseInt(harga.text.toString())
            var bayar = Integer.parseInt(uangbayar.text.toString())

            total = jmlBeli * hrg
            val kembali = bayar - total

            totalBelanja.text = "Total Belanja: " + total.toString()
            kembalian.text = "Uang Kembali: " + kembali.toString()

            if (bayar == total) {
                keterangan.text = "Keterangan: Uang Pas"
            }
            if (bayar < total) {
                keterangan.text = "Keterangan: Kurang bayar "+ abs(kembali)
            }
            if (bayar > total) {
                keterangan.text = "Keterangan: Kembalian "+ kembali
            }

            if(total >= 200000) {
                bonus.text = "Bonus: Mouse"
            } else if(total >= 400000) {
                bonus.text = "Bonus: Keyboard"
            } else if(total >= 600000) {
                bonus.text = "Bonus: Harddisk"
            } else {
                bonus.text = "Bonus: Tidak Ada Bonus"
            }
        }

        btnReset.setOnClickListener {
            namaPembeli.setText("")
            namaBarang.setText("")
            jumlahBeli.setText("")
            harga.setText("")
            uangbayar.setText("")
            totalBelanja.setText("")
            kembalian.setText("")
            bonus.setText("")
            keterangan.setText("")
        }
    }
}



