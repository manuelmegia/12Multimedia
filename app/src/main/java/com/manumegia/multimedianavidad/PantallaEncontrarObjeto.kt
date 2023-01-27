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
        var objetoSobrante = Articulo("objetoSobrante")

        binding.btnContinuar.setOnClickListener {
            this.navigateTo(PantallaDado::class.java)
        }
        binding.btnRecoger.setOnClickListener {
            val intent = Intent(this, PantallaBlanco::class.java)

            intent.putExtra("objetoEntra", miPersonaje().mochila.addArticulo(espadaCrucifijo))
            miPersonaje().mochila.addArticulo(espadaCrucifijo)

            intent.putExtra("objetoNoEntra", miPersonaje().mochila.addArticulo(objetoSobrante))
            miPersonaje().mochila.addArticulo(objetoSobrante)

            intent.putExtra("personajeCreado", miPersonaje())
            startActivity(intent)
        }
    }

}