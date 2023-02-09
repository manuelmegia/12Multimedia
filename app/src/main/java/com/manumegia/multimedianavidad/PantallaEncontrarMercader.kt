package com.manumegia.multimedianavidad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
                navigateViews(binding.vistaComprar)
                binding.viewCantidadAComprar.visibility = View.GONE
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
                    pPruebas.ventaObjeto(pPruebas.mochila.getContenido()[pPruebas.mochila.findObjeto(
                        ultimoArticuloSeleccionado.getId())], this)
                    binding.btnVenderMercader.performClick()
                }
                binding.textViewPrecio.text = "Precio: " + ultimoArticuloSeleccionado.getValor() + " PuermaCoins"
            } else {
                Toast.makeText(
                    this.applicationContext,
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
                pPruebas.mochila.addArticulo(ultimoArticuloSeleccionado, this)
            }
        }

        binding.btnComprarCancelar.setOnClickListener {
            navigateViewsFirst(binding.vistaComerciar, binding.vistaComprar)
            binding.imgMercader.setImageResource(R.drawable.mercader_rana_judio)
        }
    }
}