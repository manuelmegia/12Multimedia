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

        binding.bElRElfo.setOnClickListener {
            binding.imgElRaza.setImageResource(R.drawable.jesucristo_elfo)
        }

        binding.bElREnano.setOnClickListener {
            binding.imgElRaza.setImageResource(R.drawable.jesucristoenano)
        }

        binding.bElRGoblin.setOnClickListener {
            binding.imgElRaza.setImageResource(R.drawable.jesucristo_goblin)
        }

        binding.bElRHumano.setOnClickListener {
            binding.imgElRaza.setImageResource(R.drawable.jesucristo_humano)
        }

        binding.bAnteriorClase.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}