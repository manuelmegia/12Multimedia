package com.manumegia.multimedianavidad

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.manumegia.multimedianavidad.databinding.ActivityPantallaConfirmacionPersonajeBinding

class PantallaConfirmacionPersonaje : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaConfirmacionPersonajeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val raza = intent.getStringExtra("tipoRaza")
        val clase = intent.getStringExtra("tipoClase")

        when (raza){
            "elfo" -> binding.tuRazaFoto.setImageResource(R.drawable.jesucristo_elfo)
            "enano" -> binding.tuRazaFoto.setImageResource(R.drawable.jesucristoenano)
            "humano" -> binding.tuRazaFoto.setImageResource(R.drawable.jesucristo_humano)
            "goblin" -> binding.tuRazaFoto.setImageResource(R.drawable.jesucristo_goblin)
        }

        when (clase){
            "guerrero" -> binding.tuClaseFoto.setImageResource(R.drawable.jesucristo_guerrero)
            "berserker" -> binding.tuClaseFoto.setImageResource(R.drawable.jesucristo_berserkeraii)
            "mago" -> binding.tuClaseFoto.setImageResource(R.drawable.jesucristo_mago)
            "ladron" -> binding.tuClaseFoto.setImageResource(R.drawable.jesucristoladron__1_)
        }

        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            var nombre = binding.editText.text.toString()
            var p1 = Personaje(nombre, raza.toString(), clase.toString())

            val intent = Intent(this, PantallaBlanco::class.java)
            intent.putExtra("personajeCreado", p1.toString())
            startActivity(intent)
        }
    }
}