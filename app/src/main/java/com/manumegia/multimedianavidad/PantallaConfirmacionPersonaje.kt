package com.manumegia.multimedianavidad

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.manumegia.multimedianavidad.databinding.ActivityPantallaConfirmacionPersonajeBinding

class PantallaConfirmacionPersonaje : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallaConfirmacionPersonajeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= FirebaseAuth.getInstance()

        binding.btCAventura.isEnabled = false

        when (pPruebas.raza){
            "elfo" -> binding.tuRazaFoto.setImageResource(R.drawable.jesucristo_elfo)
            "enano" -> binding.tuRazaFoto.setImageResource(R.drawable.jesucristoenano)
            "humano" -> binding.tuRazaFoto.setImageResource(R.drawable.jesucristo_humano)
            "goblin" -> binding.tuRazaFoto.setImageResource(R.drawable.jesucristo_goblin)
        }

        when (pPruebas.clase){
            "guerrero" -> binding.tuClaseFoto.setImageResource(R.drawable.jesucristo_guerrero)
            "berserker" -> binding.tuClaseFoto.setImageResource(R.drawable.jesucristo_berserkeraii)
            "mago" -> binding.tuClaseFoto.setImageResource(R.drawable.jesucristo_mago)
            "ladron" -> binding.tuClaseFoto.setImageResource(R.drawable.jesucristoladron__1_)
        }

        binding.textNombre.addTextChangedListener (object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.btCAventura.isEnabled = binding.textNombre.text.toString() != ""
            }
        })

        binding.btCDeNuevo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btCAventura.setOnClickListener {
            pPruebas.nombre = binding.textNombre.text.toString()
            //database = FirebaseDatabase.getInstance().getReference("Personajes")
            //database = FirebaseDatabase.getInstance().getReference(auth.currentUser?.uid.toString())
            listaPartidas.add(Personaje(binding.textNombre.text.toString(), pPruebas.raza, pPruebas.clase))
            pPruebas = listaPartidas.last()
            val intent = Intent(this, PantallaDado::class.java)
            startActivity(intent)
        }
    }
}


