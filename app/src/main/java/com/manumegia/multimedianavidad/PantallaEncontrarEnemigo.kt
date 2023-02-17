package com.manumegia.multimedianavidad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import com.manumegia.multimedianavidad.databinding.ActivityPantallaEncontrarEnemigoBinding
import kotlin.random.Random

class PantallaEncontrarEnemigo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaEncontrarEnemigoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHuir.setOnClickListener {
            this.navigateTo(PantallaDado::class.java)
        }
        binding.btnLuchar.setOnClickListener {
            navigateViewsFirst(binding.vistaAtacarHuir, binding.vistaLucharHuir)
        }
        binding.btnHuirLucha.setOnClickListener {
            var checkHuir = Random.nextInt(1, 7)
            if (checkHuir >=5)
                navigateViewsFirst(binding.vistaLucharHuir, binding.vistaAtacarHuir)
            else
                turnoEnemigo()
        }
        binding.btnAtacarLucha.setOnClickListener {
        }
    }

    fun turnoEnemigo() {
        pPruebas.vida -= 20/ pPruebas.defensa
        findViewById<ProgressBar>(R.id.barraVidaUsuario).progress = pPruebas.vida
    }
    fun turnoUsuario() {
        var checkPegar = Random.nextInt(1, 7)
        if (checkPegar >=4) {
            //enemigo.vida -= pPruebas.fuerza
            findViewById<ProgressBar>(R.id.barraVidaEnemigo).progress = pPruebas.vida
        } else
            Toast.makeText(this.applicationContext, "¡Fallaste!", Toast.LENGTH_LONG).show()

    }
    fun combate() {
        turnoUsuario()
        turnoEnemigo()
    }
}