package com.manumegia.multimedianavidad

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.LinearLayout

var pPruebas = Personaje("as", "das", "gsdgs")
internal lateinit var viewGone: LinearLayout
fun Activity.navigateTo(alaQueVoy: Class<*>) {
    var intent = Intent(this, alaQueVoy)
    intent.putExtra("personajeCreado", pPruebas)
    startActivity(intent)
}

fun Activity.miPersonaje(): Personaje {
    return intent.getSerializableExtra("personajeCreado") as Personaje
}

fun navigateViews(lNew: LinearLayout){
    lNew.visibility = View.VISIBLE
    viewGone.visibility = View.GONE
}
fun navigateViewsFirst(lNew: LinearLayout, lGone: LinearLayout){
    lNew.visibility = View.VISIBLE
    lGone.visibility = View.GONE
    viewGone = lNew
}
