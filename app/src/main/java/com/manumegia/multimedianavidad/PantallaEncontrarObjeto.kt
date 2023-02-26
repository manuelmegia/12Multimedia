package com.manumegia.multimedianavidad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manumegia.multimedianavidad.databinding.ActivityPantallaEncontrarObjetoBinding

class PantallaEncontrarObjeto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaEncontrarObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        generarArticuloRandom()

        binding.imageView4.setImageResource(ultimoArticuloSeleccionado.getFoto())
        //var objetoSobrante = Articulo("objetoSobrante")

        binding.btnContinuar.setOnClickListener {
            this.navigateTo(PantallaDado::class.java)
        }

        binding.btnRecoger.setOnClickListener {
            pPruebas.mochila.addArticulo(ultimoArticuloSeleccionado, this)
            navigateTo(PantallaDado:: class.java)
        }
    }
}