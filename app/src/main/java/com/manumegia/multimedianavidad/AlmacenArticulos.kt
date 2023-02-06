package com.manumegia.multimedianavidad

import kotlin.random.Random

var almacenArticulo = arrayListOf<Articulo>()
var ultimoArticuloSeleccionado = Articulo("", R.drawable.ic_launcher_background)

fun llenarAlmacen() {
    almacenArticulo.add(Articulo("espadaCrucifijo", R.drawable.espadacrucifijo))
    almacenArticulo.add(Articulo("armaduraAlada", R.drawable.armadura_alada))
    almacenArticulo.add(Articulo("zapatosPikachu", R.drawable.zapatos_pikachu))
    almacenArticulo.add(Articulo("varaCaracol", R.drawable.varita_caracol))
    almacenArticulo.add(Articulo("pocionVida", R.drawable.pocion_vida))
}

fun generarArticuloRandom() {
    var i = Random.nextInt(almacenArticulo.size)
    ultimoArticuloSeleccionado = almacenArticulo[i]
}