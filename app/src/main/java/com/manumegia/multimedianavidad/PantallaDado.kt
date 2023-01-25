package com.manumegia.multimedianavidad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manumegia.multimedianavidad.databinding.ActivityPantallaDadoBinding
import kotlin.random.Random

class PantallaDado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaDadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val p1: Personaje = intent.getSerializableExtra("personajeCreado") as Personaje

        binding.imgBtnDado.setOnClickListener {
            var eleccZona = Random.nextInt(1, 5)
            when(eleccZona) {
                1 -> objeto(p1)
                2 -> ciudad(p1)
                3 -> mercader(p1)
                4 -> enemigo(p1)
            }
        }
    }

    fun objeto(p1:Personaje){
        val intent = Intent(this, PantallaEncontrarObjeto::class.java)
        intent.putExtra("personajeCreado", p1)
        startActivity(intent)
    }

    fun ciudad(p1:Personaje){
        val intent = Intent(this, PantallaEncontrarCiudad::class.java)
        intent.putExtra("personajeCreado", p1)
        startActivity(intent)
    }

    fun mercader(p1:Personaje){
        val intent = Intent(this, PantallaEncontrarMercader::class.java)
        intent.putExtra("personajeCreado", p1)
        startActivity(intent)
    }


    fun enemigo(p1:Personaje){
        val intent = Intent(this, PantallaEncontrarEnemigo::class.java)
        intent.putExtra("personajeCreado", p1)
        startActivity(intent)
    }
}