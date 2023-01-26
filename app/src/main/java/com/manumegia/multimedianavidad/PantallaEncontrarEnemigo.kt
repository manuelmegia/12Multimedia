package com.manumegia.multimedianavidad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manumegia.multimedianavidad.databinding.ActivityPantallaEncontrarEnemigoBinding

class PantallaEncontrarEnemigo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaEncontrarEnemigoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHuir.setOnClickListener {
            this.navigateTo(PantallaDado::class.java)
        }
        binding.btnLuchar.setOnClickListener {
            this.navigateTo(PantallaBlanco::class.java)
        }
    }
}