package com.manumegia.multimedianavidad

import kotlin.random.Random

class Personaje (private var nombre: String,
                 private var raza: String,
                 private var clase: String,
    ): java.io.Serializable{


    var fuerza: Int = Random.nextInt(10, 15)
    var defensa: Int = Random.nextInt(1, 5)
    var pesoMochila: Int = 100
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
        return "Personaje(nombre='$nombre', raza='$raza', clase='$clase', fuerza=$fuerza, defensa=$defensa, pesoMochila=$pesoMochila, vida=$vida, monedero=$monedero)"
    }
}

