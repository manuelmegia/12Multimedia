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

        var envio_imagen = ""

        binding.bElPGuerrero.setOnClickListener {
            binding.imgElClase.setImageResource(R.drawable.jesucristo_guerrero)
            envio_imagen = "guerrero"
        }

        binding.bElPLadron.setOnClickListener {
            binding.imgElClase.setImageResource(R.drawable.jesucristoladron__1_)
            envio_imagen = "ladron"
        }

        binding.bElPMago.setOnClickListener {
            binding.imgElClase.setImageResource(R.drawable.jesucristo_mago)
            envio_imagen = "mago"
        }

        binding.bElPBerserker.setOnClickListener {
            binding.imgElClase.setImageResource(R.drawable.jesucristo_berserkeraii)
            envio_imagen = "berserker"
        }

        binding.bElPInicio.setOnClickListener {
            val intent = Intent(this, PantallaClases::class.java)
            intent.putExtra("tipoClase", envio_imagen)
            startActivity(intent)
        }
    }
}