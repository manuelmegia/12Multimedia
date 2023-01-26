package com.manumegia.multimedianavidad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manumegia.multimedianavidad.databinding.ActivityPantallaEncontrarCiudadBinding

class PantallaEncontrarCiudad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaEncontrarCiudadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinuar.setOnClickListener {
            this.navigateTo(PantallaDado::class.java)
        }
        binding.btnEntrar.setOnClickListener {
            this.navigateTo(PantallaBlanco::class.java)
        }
    }
}