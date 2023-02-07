package com.manumegia.multimedianavidad

import android.content.Context
import android.widget.Toast
import kotlin.random.Random

class Personaje (var nombre: String,
                 var raza: String,
                 var clase: String,
    ): java.io.Serializable{


    var pesoMochila: Int = 100
    var mochila = Mochila(pesoMochila)
    var fuerza: Int = Random.nextInt(10, 16)
    var defensa: Int = Random.nextInt(1, 6)
    var vida: Int = 200
    var monedero = HashMap<Int, Int>()

    init {
        monedero[1] = 0
        monedero[5] = 0
        monedero[10] = 0
        monedero[25] = 0
        monedero[100] = 0
    }

    fun cashConverter(articulo: Articulo) {
        var total = 0
        var i = 0
        var coins = arrayListOf(1, 5, 10, 25, 100)
        coins.sortDescending()

        while (total < articulo.getValor() && i < coins.size) {
            if (total + coins[i] <= articulo.getValor()) {
                total += coins[i]
                monedero[coins[i]] = monedero[coins[i]]!! + 1
            } else
                i++
        }
    }

    fun ventaObjeto(articulo: Articulo, con: Context) {
        cashConverter(articulo)
        mochila.getContenido().remove(articulo)
        pPruebas.mochila.setPesoMochila(pPruebas.mochila.getPesoMochila() + articulo.getPeso())
        return Toast.makeText(con.applicationContext, "Articulo '" + articulo.getId() + "' eliminado, peso restante de la Mochila: " + pPruebas.mochila.getPesoMochila(), Toast.LENGTH_SHORT).show()
    }

    override fun toString(): String {
        return "Personaje(nombre='$nombre', raza='$raza', clase='$clase', pesoMochila=$pesoMochila, mochila=$mochila, fuerza=$fuerza, defensa=$defensa, vida=$vida, monedero=$monedero)"
    }

}

