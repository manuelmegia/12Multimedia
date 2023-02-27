package com.manumegia.multimedianavidad

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.manumegia.multimedianavidad.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        binding.buttonLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.editTextTextEmailAddress.text.toString(),
                binding.editTextTextPassword.text.toString()
            ).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    database = FirebaseDatabase.getInstance().reference
                    database.get().addOnCompleteListener {
                        if (it.isSuccessful) {
                            val products = it.result.getValue(EstructuraDB::class.java)
                            if (products != null) {
                                almacenArticulo = products.AlmacenArticulos!! ?: ArrayList<Articulo>()
                                Log.d(ContentValues.TAG, products.toString())
                            } else {
                                Log.d(ContentValues.TAG, it.exception?.message.toString())
                            }
                            val intent = Intent(this, CargarCrearPersonaje::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Log.d(ContentValues.TAG, it.exception?.message.toString())
                        }
                    }.addOnFailureListener { exception ->
                        Toast.makeText(
                            applicationContext,
                            exception.localizedMessage,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                binding.btnLoginARegistro.setOnClickListener {
                    val intent = Intent(this, Registro::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}