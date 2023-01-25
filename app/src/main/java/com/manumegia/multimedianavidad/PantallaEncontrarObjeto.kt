package com.manumegia.multimedianavidad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manumegia.multimedianavidad.databinding.ActivityPantallaEncontrarObjetoBinding

class PantallaEncontrarObjeto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaEncontrarObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val p1: Personaje = intent.getSerializableExtra("personajeCreado") as Personaje

        binding.btnContinuar.setOnClickListener {
            val intent = Intent(this, PantallaDado::class.java)
            intent.putExtra("personajeCreado", p1)
            startActivity(intent)
        }
        binding.btnRecoger.setOnClickListener {
            val intent = Intent(this, PantallaBlanco::class.java)
            intent.putExtra("personajeCreado", p1)
            startActivity(intent)
        }
    }
}