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

        var envio_imagen = ""
        val clase = intent.getStringExtra("tipoClase")

        binding.bElRElfo.setOnClickListener {
            binding.imgElRaza.setImageResource(R.drawable.jesucristo_elfo)
            envio_imagen = "elfo"
        }

        binding.bElREnano.setOnClickListener {
            binding.imgElRaza.setImageResource(R.drawable.jesucristoenano)
            envio_imagen = "enano"
        }

        binding.bElRGoblin.setOnClickListener {
            binding.imgElRaza.setImageResource(R.drawable.jesucristo_goblin)
            envio_imagen = "goblin"
        }

        binding.bElRHumano.setOnClickListener {
            binding.imgElRaza.setImageResource(R.drawable.jesucristo_humano)
            envio_imagen = "humano"
        }

        binding.bAnteriorClase.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.bElRSiguiente.setOnClickListener {
            val intent = Intent(this, PantallaConfirmacionPersonaje::class.java)
            intent.putExtra("tipoRaza", envio_imagen)
            intent.putExtra("tipoClase", clase)
            startActivity(intent)
        }

        binding.bAnteriorClase.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}