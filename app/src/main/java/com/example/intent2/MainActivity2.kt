package com.example.intent2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Recoge el Intent que ha iniciado la actividad
        val intent = getIntent()

        setResult(Activity.RESULT_OK, intent);
        Log.d("MENSAJES", "Actualizado")

        // Cierro la activity
        finish()

    }
}