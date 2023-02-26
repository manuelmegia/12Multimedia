package com.manumegia.multimedianavidad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.manumegia.multimedianavidad.databinding.ActivityPantallaEncontrarMercaderBinding

class PantallaEncontrarMercader : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaEncontrarMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                navigateViews(binding.vistaComprar)
                binding.btnComprarComprar.text = "Vender"
                binding.imgMercader.setImageResource(pPruebas.mochila.getContenido()[0].getFoto())
                binding.spinnerCantidades.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, pPruebas.mochila.getContenido())

                binding.spinnerCantidades?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        ultimoArticuloSeleccionado = binding.spinnerCantidades.selectedItem as Articulo
                        binding.imgMercader.setImageResource(ultimoArticuloSeleccionado.getFoto())
                    }
                }
                binding.btnComprarComprar.setOnClickListener {
                    try {
                    pPruebas.ventaMultiplesObjetos(pPruebas.mochila.getContenido()[pPruebas.mochila.findObjeto(
                        ultimoArticuloSeleccionado.getId())], binding.editTextNumeroItems.text.toString().toInt(), this)
                    binding.btnVenderMercader.performClick()
                    } catch (e: Exception) {
                        Toast.makeText(
                            this,
                            "Debes seleccionar el número de artículos que quieres vender",
                            Toast.LENGTH_LONG
                        ).show()
                        println(e)
                    }
                }

            } else {
                Toast.makeText(
                    this,
                    "No existen artículos en esta mochila",
                    Toast.LENGTH_LONG
                ).show()
                navigateViewsFirst(binding.vistaComerciar, binding.vistaComprar)
                binding.imgMercader.setImageResource(R.drawable.mercader_rana_judio)
            }
        }
        binding.btnComprarMercader.setOnClickListener {
            navigateViewsFirst(binding.vistaComprar, binding.vistaComerciar)
            binding.btnComprarComprar.text = "Comprar"
            binding.textViewPrecio.text = "Precio: " + ultimoArticuloSeleccionado.getValor() * 12.5 + " PuermaCoins"
            binding.spinnerCantidades.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, almacenArticulo)

            binding.spinnerCantidades?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {}
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    ultimoArticuloSeleccionado = binding.spinnerCantidades.selectedItem as Articulo
                    binding.imgMercader.setImageResource(ultimoArticuloSeleccionado.getFoto())
                }
            }
            binding.btnComprarComprar.setOnClickListener {
                try {
                    pPruebas.mochila.addMultiplesArticulos(ultimoArticuloSeleccionado, binding.editTextNumeroItems.text.toString().toInt(), this)
                } catch (e: Exception) {
                    Toast.makeText(
                        this,
                        "Debes seleccionar el número de artículos que quieres comprar",
                        Toast.LENGTH_LONG
                    ).show()
                println(e)
            }
            }
        }
        binding.btnComprarCancelar.setOnClickListener {
            navigateViewsFirst(binding.vistaComerciar, binding.vistaComprar)
            binding.imgMercader.setImageResource(R.drawable.mercader_rana_judio)
        }
        binding.editTextNumeroItems.doOnTextChanged { text, start, before, count ->
            try {
                binding.textViewPrecio.text = "Precio: " + text.toString()
                    .toInt() * ultimoArticuloSeleccionado.getValor() * 12.5
            } catch (e: Exception) {
                binding.textViewPrecio.text = "Precio: 0"
                println(e)
            }
        }
    }
}