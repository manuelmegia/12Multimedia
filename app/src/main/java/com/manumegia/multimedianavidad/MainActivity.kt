package com.manumegia.multimedianavidad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bGuerrero = findViewById<Button>(R.id.button)
        var bLadron = findViewById<Button>(R.id.button2)
        var bMago = findViewById<Button>(R.id.button3)
        var bBerserker = findViewById<Button>(R.id.button4)
        var bInicio = findViewById<Button>(R.id.button5)
        var fInicio = findViewById<ImageView>(R.id.imageView)

        bGuerrero.setOnClickListener {
            fInicio.setImageResource(R.drawable.jesucristoguerrero)
        }

        bLadron.setOnClickListener {
            fInicio.setImageResource(R.drawable.jesucristoladron)
        }

        bMago.setOnClickListener {
            fInicio.setImageResource(R.drawable.jesucristo_mago)
        }

        bBerserker.setOnClickListener {
            fInicio.setImageResource(R.drawable.jesucristo_berserker)
        }


        bInicio.setOnClickListener {
            val intent = Intent(this, PantallaClases::class.java)
            startActivity(intent)
        }
    }
}