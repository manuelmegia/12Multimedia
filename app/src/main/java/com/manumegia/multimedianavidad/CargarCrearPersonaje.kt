package com.manumegia.multimedianavidad

import android.R
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.manumegia.multimedianavidad.databinding.ActivityCargarCrearPersonajeBinding
import com.manumegia.multimedianavidad.databinding.ActivityMainBinding

class CargarCrearPersonaje : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCargarCrearPersonajeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference("Personajes")
        database.child(auth.currentUser?.uid.toString()).get().addOnCompleteListener {
            if (it.isSuccessful) {
                val products = it.result.getValue(Estructura2DB::class.java)
                if (products != null) {
                    listaPartidas = (products.ListaPersonajes!! ?: ArrayList<Personaje>())
                    Log.d(ContentValues.TAG, products.toString())
                } else {
                    Log.d(ContentValues.TAG, it.exception?.message.toString())
                }
                binding.button3.setOnClickListener { navigateTo(PantallaDado::class.java) }
                binding.btnCrearPersonaje.setOnClickListener { navigateTo(MainActivity::class.java) }
                binding.btnCargarPersonaje.setOnClickListener {
                    binding.layoutCargar.visibility = View.VISIBLE
                }

                binding.spinner.adapter =
                    ArrayAdapter(this, R.layout.simple_spinner_item, listaPartidas)
                binding.spinner?.onItemSelectedListener =
                    object : AdapterView.OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {}
                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            pPruebas = binding.spinner.selectedItem as Personaje
                        }
                    }
            } else {
                Log.d(ContentValues.TAG, it.exception?.message.toString())
            }
        }
    }
}