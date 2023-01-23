package com.example.intent2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    // definir el requestCode
    val RESULTADO_UNO = 1
    val RESULTADO_DOS = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bCamara = findViewById<Button>(R.id.bCamara)

        bCamara.setOnClickListener {
            // Crea un Intent para iniciar la segunda actividad
            val intent = Intent(this, MainActivity2::class.java)

            startActivityForResult(intent, RESULTADO_UNO)
            startActivityForResult(intent, RESULTADO_DOS)

        }
    }
}