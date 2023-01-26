package com.manumegia.multimedianavidad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manumegia.multimedianavidad.databinding.ActivityPantallaEncontrarMercaderBinding

class PantallaEncontrarMercader : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaEncontrarMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinuar.setOnClickListener {
            this.navigateTo(PantallaDado::class.java)
        }
        binding.btnComerciar.setOnClickListener {
            this.navigateTo(PantallaBlanco::class.java)

        }
    }
}