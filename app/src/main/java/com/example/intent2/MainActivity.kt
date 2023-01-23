package com.example.intent2

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    // definir el requestCode
    val RESULTADO_UNO = 1
    val RESULTADO_DOS = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bCamara = findViewById<Button>(R.id.bCamara)
        val bAleatorio = findViewById<Button>(R.id.bAleatorio)

        bCamara.setOnClickListener {
            // Crea un Intent para iniciar la actividad
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takePictureIntent, RESULTADO_UNO)
                }
            }

        }

        bAleatorio.setOnClickListener {

            // Crea un Intent para la segunda  actividad
            val intent = Intent(this, MainActivity2::class.java)

            val random = Random()
            val nRandom1 = random.nextInt(10) + 1
            val nRandom2 = random.nextInt(10) + 1

            // Añade números al Intent
            intent.putExtra("numero1", nRandom1)
            intent.putExtra("numero2", nRandom2)

            // Inicia la tercera actividad
            startActivityForResult(intent, RESULTADO_DOS)
        }

    }


    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val imagen = findViewById<ImageView>(R.id.imagen)
        val resultado = findViewById<TextView>(R.id.texto)

        if (requestCode == RESULTADO_UNO && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imagen.setImageBitmap(imageBitmap)
        }

        if (requestCode == RESULTADO_DOS && resultCode == RESULT_OK) {
            resultado.text = data?.getStringExtra("suma")
        }



        }
    }

