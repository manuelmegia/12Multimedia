package com.manumegia.multimedianavidad

import android.app.Activity
import android.content.Intent

fun Activity.navigateTo(alaQueVoy: Class<*>) {
    var intent = Intent(this, alaQueVoy)
    intent.putExtra("personajeCreado", miPersonaje())
    startActivity(intent)
}

fun Activity.miPersonaje(): Personaje {
    return intent.getSerializableExtra("personajeCreado") as Personaje
}