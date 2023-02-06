package com.manumegia.multimedianavidad

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.manumegia.multimedianavidad.databinding.PantallaClasesBinding

class PantallaClases : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = PantallaClasesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bElRSiguiente.isEnabled = false

        binding.bElRElfo.setOnClickListener {
            binding.imgElRaza.setImageResource(R.drawable.jesucristo_elfo)
            pPruebas.raza = "elfo"
            binding.bElRSiguiente.isEnabled = true
        }

        binding.bElREnano.setOnClickListener {
            binding.imgElRaza.setImageResource(R.drawable.jesucristoenano)
            pPruebas.raza = "enano"
            binding.bElRSiguiente.isEnabled = true
        }

        binding.bElRGoblin.setOnClickListener {
            binding.imgElRaza.setImageResource(R.drawable.jesucristo_goblin)
            pPruebas.raza = "goblin"
            binding.bElRSiguiente.isEnabled = true
        }

        binding.bElRHumano.setOnClickListener {
            binding.imgElRaza.setImageResource(R.drawable.jesucristo_humano)
            pPruebas.raza = "humano"
            binding.bElRSiguiente.isEnabled = true
        }

        binding.bAnteriorClase.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.bElRSiguiente.setOnClickListener {
            val intent = Intent(this, PantallaConfirmacionPersonaje::class.java)
            startActivity(intent)
        }

        binding.bAnteriorClase.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}