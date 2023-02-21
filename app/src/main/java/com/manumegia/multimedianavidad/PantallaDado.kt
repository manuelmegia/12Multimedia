package com.manumegia.multimedianavidad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.R
import com.manumegia.multimedianavidad.databinding.ActivityPantallaDadoBinding
import kotlin.random.Random

class PantallaDado : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaDadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBtnDado.setOnClickListener {
            //var eleccZona = Random.nextInt(1, 5)
            var eleccZona = 3
            when(eleccZona) {
                1 -> this.navigateTo(PantallaEncontrarObjeto::class.java)
                2 -> this.navigateTo(PantallaEncontrarCiudad::class.java)
                3 -> this.navigateTo(PantallaEncontrarMercader::class.java)
                4 -> this.navigateTo(PantallaEncontrarEnemigo::class.java)
            }
        }

        binding.btnGuardarFirebase.setOnClickListener {
            database = FirebaseDatabase.getInstance().getReference("Personajes")
            database.child(pPruebas.nombre).setValue(pPruebas).addOnSuccessListener {
                Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}