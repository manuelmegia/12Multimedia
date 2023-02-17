package com.manumegia.multimedianavidad

import android.content.Context
import android.widget.Toast

class Mochila(private var pesoMochila: Int) : java.io.Serializable {
    private var contenido = ArrayList<Articulo>()

    fun getPesoMochila(): Int {
        return pesoMochila
    }

    fun setPesoMochila(nuevoPeso: Int) {
        pesoMochila = nuevoPeso
    }

    fun addArticulo(articulo: Articulo, con: Context) {
        if (articulo.getPeso() <= pesoMochila) {
            contenido.add(articulo)
            this.pesoMochila -= articulo.getPeso()
        } else {
            return Toast.makeText(
                con,
                "El articulo '" + articulo.getId() + "' no puede entrar porque la mochila está llena, debes vender artículos",
                Toast.LENGTH_SHORT
            ).show()
        }
        return Toast.makeText(
            con.applicationContext,
            "Articulo '" + articulo.getId() + "' introducido, peso restante de la Mochila: " + pesoMochila,
            Toast.LENGTH_SHORT
        ).show()
    }


    fun addMultiplesArticulos(articulo: Articulo, cantidad: Int, con: Context) {
        if (articulo.getPeso() * cantidad <= pesoMochila) {
            for (i in 0 until cantidad) {
                if (articulo.getPeso() <= pesoMochila) {
                    contenido.add(articulo)
                    this.pesoMochila -= articulo.getPeso()
                }
            }
            return Toast.makeText(
                con,
                "Todos los artículos introducidos con éxito, peso restante de la Mochila: $pesoMochila",
                Toast.LENGTH_SHORT
            ).show()
        } else
            return Toast.makeText(
                con,
                "No hay espacio suficiente en la mochila, peso restante de la Mochila: $pesoMochila",
                Toast.LENGTH_SHORT
            ).show()
    }

    fun getContenido(): ArrayList<Articulo> {
        return contenido
    }

    fun setContenido(nuevoContenido: ArrayList<Articulo>) {
        contenido = nuevoContenido
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

    fun howManyItems(articuloARevisar: Articulo): Int {
        var numItems = 0
        for (n in contenido){
            if (articuloARevisar.getId() == n.getId())
                numItems++
        }
        return numItems
    }
}