package com.manumegia.multimedianavidad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manumegia.multimedianavidad.databinding.ActivityPantallaEncontrarObjetoBinding

class PantallaEncontrarObjeto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaEncontrarObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var espadaCrucifijo = Articulo("espadaCrucifijo")

        binding.btnContinuar.setOnClickListener {
            this.navigateTo(PantallaDado::class.java)
        }
        binding.btnRecoger.setOnClickListener {
            miPersonaje().mochila.addArticulo(espadaCrucifijo)
            this.navigateTo(PantallaBlanco::class.java)
        }
    }

}