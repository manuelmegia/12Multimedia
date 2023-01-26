package com.manumegia.multimedianavidad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.manumegia.multimedianavidad.databinding.ActivityPantallaBlancoBinding

class PantallaBlanco : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaBlancoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pCreado: Personaje = intent.getSerializableExtra("personajeCreado") as Personaje
        var oE = intent.getStringExtra("objetoEntra")
        var oNE = intent.getStringExtra("objetoNoEntra")
        binding.textPersonaje.text = pCreado.toString()
        binding.textPersonaje.text = oE
        binding.textPersonaje.text = oNE
    }
}