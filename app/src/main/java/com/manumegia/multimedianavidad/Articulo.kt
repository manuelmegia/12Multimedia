package com.manumegia.multimedianavidad

import android.graphics.drawable.Drawable
import android.widget.ImageView

class Articulo(
    private var id: String,
    private var fto: Int,
    private var peso: Int = 10,
    private var valor: Int = 10,
    private var vida: Int = 20
) : java.io.Serializable {

    private lateinit var foto: ImageView

    fun getFoto(): Int {
        return fto
    }

    fun getPeso(): Int {
        return peso
    }

    fun getValor(): Int {
        return valor
    }

    fun getId(): String {
        return id
    }

    fun toStringMostrarTodo(): String {
        return "[ID:$id, Peso:$peso, Valor:$valor], Vida:$vida"
    }
    override fun toString(): String {
        return id
    }
}