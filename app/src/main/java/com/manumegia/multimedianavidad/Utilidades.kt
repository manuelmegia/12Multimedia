package com.manumegia.multimedianavidad

import android.app.Activity
import android.content.Intent

var pPruebas = Personaje("as", "das", "gsdgs")

fun Activity.navigateTo(alaQueVoy: Class<*>) {
    var intent = Intent(this, alaQueVoy)
    intent.putExtra("personajeCreado", pPruebas)
    startActivity(intent)
}

fun Activity.miPersonaje(): Personaje {
    return intent.getSerializableExtra("personajeCreado") as Personaje
}