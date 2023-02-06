package com.manumegia.multimedianavidad

import android.content.Context
import android.widget.Toast

class Mochila(private var pesoMochila: Int) : java.io.Serializable {
    private var contenido = ArrayList<Articulo>()

    fun getPesoMochila(): Int {
        return pesoMochila
    }

    fun addArticulo(articulo: Articulo, con: Context) {
        if (articulo.getPeso() <= pesoMochila) {
            contenido.add(articulo)
            this.pesoMochila -= articulo.getPeso()
        } else {
            return Toast.makeText(con, "El articulo '" + articulo.getId() + "' no puede entrar porque la mochila está llena, debes vender artículos", Toast.LENGTH_LONG).show()
        }
        return Toast.makeText(con.applicationContext, "Articulo '" + articulo.getId() + "' introducido, peso restante de la Mochila: " + pesoMochila, Toast.LENGTH_LONG).show()
    }

    fun getContenido(): ArrayList<Articulo> {
        return contenido
    }

    override fun toString(): String {
        return "Mochila(pesoMochila=$pesoMochila, contenido=$contenido)"
    }

    fun findObjeto(id: String): Int {
        for ((indice, item) in contenido.withIndex()) {
            if (item.getId() == id) {
                return indice
            }
        }
        return -1
    }

}