package com.manumegia.multimedianavidad

import kotlin.random.Random

class Personaje (private var nombre: String,
                 private var raza: String,
                 private var clase: String,
    ): java.io.Serializable{


    var pesoMochila: Int = 10
    var mochila = Mochila(pesoMochila)
    var fuerza: Int = Random.nextInt(10, 16)
    var defensa: Int = Random.nextInt(1, 6)
    var vida: Int = 200
    var monedero = HashMap<Int, Int>()

    init {
        monedero.put(1, 0)
        monedero.put(5, 0)
        monedero.put(10, 0)
        monedero.put(25, 0)
        monedero.put(100, 0)
    }

    override fun toString(): String {
        return "Personaje(nombre='$nombre', raza='$raza', clase='$clase', pesoMochila=$pesoMochila, mochila=$mochila, fuerza=$fuerza, defensa=$defensa, vida=$vida, monedero=$monedero)"
    }

}

