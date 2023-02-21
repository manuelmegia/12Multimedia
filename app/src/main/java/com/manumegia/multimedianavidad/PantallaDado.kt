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

        binding.imgBtnDado.setOnClickListener {
            //var eleccZona = Random.nextInt(1, 5)
            var eleccZona = 4
            when(eleccZona) {
                1 -> this.navigateTo(PantallaEncontrarObjeto::class.java)
                2 -> this.navigateTo(PantallaEncontrarCiudad::class.java)
                3 -> this.navigateTo(PantallaEncontrarMercader::class.java)
                4 -> this.navigateTo(PantallaEncontrarEnemigo::class.java)
            }
        }
    }
}