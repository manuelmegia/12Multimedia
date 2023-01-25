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

        val p1: Personaje = intent.getSerializableExtra("personajeCreado") as Personaje

        binding.btnHuir.setOnClickListener {
            val intent = Intent(this, PantallaDado::class.java)
            intent.putExtra("personajeCreado", p1)
            startActivity(intent)
        }
        binding.btnLuchar.setOnClickListener {
            val intent = Intent(this, PantallaBlanco::class.java)
            intent.putExtra("personajeCreado", p1)
            startActivity(intent)
        }
    }
}