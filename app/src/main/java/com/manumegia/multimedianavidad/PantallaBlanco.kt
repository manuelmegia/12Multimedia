package com.manumegia.multimedianavidad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manumegia.multimedianavidad.databinding.ActivityPantallaBlancoBinding
import com.manumegia.multimedianavidad.databinding.ActivityPantallaConfirmacionPersonajeBinding

class PantallaBlanco : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaBlancoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pCreado = intent.getStringExtra("personajeCreado")
        binding.textView2.text = pCreado
    }
}