package com.manumegia.multimedianavidad

class Articulo(
    private var id: String,
    private var peso: Int = 10,
    private var valor: Int = 10,
    private var vida: Int = 20
) : java.io.Serializable {

    fun getPeso(): Int {
        return peso
    }

    fun getValor(): Int {
        return valor
    }

    fun getId(): String {
        return id
    }

    override fun toString(): String {
        return "[ID:$id, Peso:$peso, Valor:$valor], Vida:$vida"
    }
}