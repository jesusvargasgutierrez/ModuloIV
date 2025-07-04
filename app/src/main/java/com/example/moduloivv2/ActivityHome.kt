package com.example.moduloivv2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btncountries = findViewById<AppCompatButton>(R.id.btn_home_countries)
        val btnhomecalc = findViewById<AppCompatEditText>(R.id.btn_home_calc)
        val btnacerca = findViewById<AppCompatEditText>(R.id.btn_home_acerca)

        btncountries.setOnClickListener {
            val intent = Intent(this,ActivityCountry::class.java)
            startActivity(intent)
            finish()
        }

        btnhomecalc.setOnClickListener {
            val intent = Intent(this,ActivityCalculadora::class.java)
            startActivity(intent)
            finish()
        }

        btnacerca.setOnClickListener {
            val intent = Intent(this,ActivityAcerca::class.java)
            startActivity(intent)
            finish()
        }
    }
}