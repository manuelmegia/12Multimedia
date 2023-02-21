package com.manumegia.multimedianavidad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import com.manumegia.multimedianavidad.databinding.ActivityPantallaEncontrarEnemigoBinding
import kotlin.random.Random

class PantallaEncontrarEnemigo : AppCompatActivity() {
    lateinit var enemigo: Enemigo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaEncontrarEnemigoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        eleccionEnemigo()
        binding.imageView2.setImageResource(enemigo.foto)
        binding.barraVidaEnemigo.max = enemigo.vida
        binding.barraVidaUsuario.max = pPruebas.vidaMax
        binding.barraVidaEnemigo.progress = enemigo.vida
        binding.barraVidaUsuario.progress = pPruebas.vida

        binding.btnHuir.setOnClickListener {
            this.navigateTo(PantallaDado::class.java)
        }
        binding.btnLuchar.setOnClickListener {
            navigateViewsFirst(binding.vistaAtacarHuir, binding.vistaLucharHuir)
        }
        binding.btnHuirLucha.setOnClickListener {
            var checkHuir = Random.nextInt(1, 7)
            if (checkHuir >= 5)
                navigateViewsFirst(binding.vistaLucharHuir, binding.vistaAtacarHuir)
            else
                turnoEnemigo()
        }
        binding.btnObjetoLucha.setOnClickListener {
            if (pPruebas.mochila.getContenido().isNotEmpty()) {
                pPruebas.vida += 20
                pPruebas.mochila.getContenido().removeAt(0)
                Toast.makeText(
                    this.applicationContext,
                    "¡Te curaste 20 de vida!",
                    Toast.LENGTH_LONG
                ).show()
                binding.barraVidaUsuario.progress += 20
            } else
                Toast.makeText(
                    this.applicationContext,
                    "No tienes objetos para curarte",
                    Toast.LENGTH_LONG
                ).show()
        }
        binding.btnAtacarLucha.setOnClickListener {
            combate()
        }
    }

    fun turnoEnemigo() {
        pPruebas.vida -= 20 / pPruebas.defensa
        findViewById<ProgressBar>(R.id.barraVidaUsuario).progress = pPruebas.vida
    }

    fun turnoUsuario() {
        var checkPegar = Random.nextInt(1, 7)
        if (checkPegar >= 4) {
            enemigo.vida -= pPruebas.fuerza
            findViewById<ProgressBar>(R.id.barraVidaEnemigo).progress = enemigo.vida
        } else
            Toast.makeText(this.applicationContext, "¡Fallaste!", Toast.LENGTH_LONG).show()

    }

    fun checkHP() {
        if (pPruebas.vida <= 0) {
            navigateTo(PantallaBlanco::class.java)
        } else if (enemigo.vida <= 0) {
            Toast.makeText(this, "¡¡Victoria!!", Toast.LENGTH_SHORT).show()
            findObjetoAlmacen("pocionVida")
            pPruebas.mochila.addMultiplesArticulos(ultimoArticuloSeleccionado, 3, this)
            navigateTo(PantallaDado::class.java)
        }
    }

    fun combate() {
        turnoUsuario()
        turnoEnemigo()
        checkHP()
    }

    fun eleccionEnemigo() {
        var eleccion = Random.nextInt(1, 3)
        when (eleccion) {
            1 -> enemigo = Enemigo(100, 20, R.drawable.rana_enemigo_normal)
            2 -> enemigo = Enemigo(200, 30, R.drawable.enemigo_rana_mafiosa)
        }
    }
}