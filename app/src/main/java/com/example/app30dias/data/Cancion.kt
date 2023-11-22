package com.example.app30dias.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.app30dias.R

data class Cancion(
    @StringRes val dia: Int,
    @StringRes val titulo: Int,
    @DrawableRes val imagen: Int,
    @StringRes val descripcion: Int
)

val canciones = listOf(
    Cancion(R.string.dia_1, R.string.cancion_1, R.drawable.nirvana, R.string.descripcion_1),
    Cancion(R.string.dia_2, R.string.cancion_2, R.drawable.cranberries, R.string.descripcion_2),
    Cancion(R.string.dia_3, R.string.cancion_3, R.drawable.backstreet_boys, R.string.descripcion_3),
    Cancion(R.string.dia_4, R.string.cancion_4, R.drawable.haddaway, R.string.descripcion_4),
    Cancion(R.string.dia_5, R.string.cancion_5, R.drawable.britney, R.string.descripcion_5),
    Cancion(R.string.dia_6, R.string.cancion_6, R.drawable.rem, R.string.descripcion_6),
    Cancion(R.string.dia_7, R.string.cancion_7, R.drawable.guns, R.string.descripcion_7),
    Cancion(R.string.dia_8, R.string.cancion_8, R.drawable.cher, R.string.descripcion_8),
    Cancion(R.string.dia_9, R.string.cancion_9, R.drawable.fugees, R.string.descripcion_9),
    Cancion(R.string.dia_10, R.string.cancion_10, R.drawable.maddona, R.string.descripcion_10),
    Cancion(R.string.dia_11, R.string.cancion_11, R.drawable.radiohead, R.string.descripcion_11),
    Cancion(R.string.dia_12, R.string.cancion_12, R.drawable.spice, R.string.descripcion_12),
    Cancion(R.string.dia_13, R.string.cancion_13, R.drawable.whitney, R.string.descripcion_13),
    Cancion(R.string.dia_14, R.string.cancion_14, R.drawable.destiny, R.string.descripcion_14),
    Cancion(R.string.dia_15, R.string.cancion_15, R.drawable.celine, R.string.descripcion_15)
)
