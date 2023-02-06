package com.manumegia.multimedianavidad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manumegia.multimedianavidad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bElPInicio.isEnabled = false

        binding.bElPGuerrero.setOnClickListener {
            binding.imgElClase.setImageResource(R.drawable.jesucristo_guerrero)
            pPruebas.clase = "guerrero"
            binding.bElPInicio.isEnabled = true
        }

        binding.bElPLadron.setOnClickListener {
            binding.imgElClase.setImageResource(R.drawable.jesucristoladron__1_)
            pPruebas.clase = "ladron"
            binding.bElPInicio.isEnabled = true
        }

        binding.bElPMago.setOnClickListener {
            binding.imgElClase.setImageResource(R.drawable.jesucristo_mago)
            pPruebas.clase = "mago"
            binding.bElPInicio.isEnabled = true
        }

        binding.bElPBerserker.setOnClickListener {
            binding.imgElClase.setImageResource(R.drawable.jesucristo_berserkeraii)
            pPruebas.clase = "berserker"
            binding.bElPInicio.isEnabled = true
        }

        binding.bElPInicio.setOnClickListener {
            val intent = Intent(this, PantallaClases::class.java)
            startActivity(intent)
        }
    }
}