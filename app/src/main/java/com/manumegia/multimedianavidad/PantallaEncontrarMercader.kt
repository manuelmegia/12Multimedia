package com.manumegia.multimedianavidad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.manumegia.multimedianavidad.databinding.ActivityPantallaEncontrarMercaderBinding

class PantallaEncontrarMercader : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaEncontrarMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        llenarAlmacen()

        binding.btnContinuar.setOnClickListener {
            this.navigateTo(PantallaDado::class.java)
        }

        binding.btnComerciar.setOnClickListener {
            navigateViewsFirst(binding.vistaComerciar, binding.vistaMercader)
        }

        binding.btnCancelarMercader.setOnClickListener {
            navigateViewsFirst(binding.vistaMercader, binding.vistaComerciar)
            binding.imgMercader.setImageResource(R.drawable.mercader_rana_judio)
        }

        binding.btnVenderMercader.setOnClickListener {
            if (pPruebas.mochila.getContenido().isNotEmpty()){
                binding.imgMercader.setImageResource(pPruebas.mochila.getContenido()[0].getFoto())
                pPruebas.ventaObjeto(pPruebas.mochila.getContenido()[0], this)
            } else
                Toast.makeText(this.applicationContext,"No existen artículos en esta mochila", Toast.LENGTH_LONG).show()
        }

        binding.btnComprarMercader.setOnClickListener {
            navigateViews(binding.vistaComprar)
            binding.imgMercader.setImageResource(generarYObtenerArticuloRandom().getFoto())
            binding.textViewPrecio.text = pPruebas.toString()
        }

        binding.btnComprarCancelar.setOnClickListener {
            navigateViewsFirst(binding.vistaComerciar, binding.vistaComprar)
            binding.imgMercader.setImageResource(R.drawable.mercader_rana_judio)
        }

        binding.btnComprarComprar.setOnClickListener {
            binding.imgMercader.setImageResource(ultimoArticuloSeleccionado.getFoto())
            pPruebas.mochila.addArticulo(ultimoArticuloSeleccionado, this)
            binding.imgMercader.setImageResource(generarYObtenerArticuloRandom().getFoto())
        }
    }
}