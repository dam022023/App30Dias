package com.example.app30dias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items;
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.app30dias.data.Cancion
import com.example.app30dias.data.canciones
import com.example.app30dias.ui.theme.App30DiasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App30DiasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App30Dias()
                }
            }
        }
    }
}

//Funcion para que aparezcan todos los elementos
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App30Dias() {
    Scaffold (
        topBar = {
            App30DiasBarraSuperior()
        }
    ) { it->
        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            contentPadding = it
        ){
            items(canciones) {
                App30DiasBloque(
                    cancion = it,
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}


//Funcion para que aparezca el elemento dentro de un bloque
@Composable
fun App30DiasBloque(
    cancion: Cancion,
    modifier: Modifier = Modifier
) {
    Card (modifier = modifier
        .clip(MaterialTheme.shapes.large)){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ){
            App30DiasDiaYTitulo(cancion.dia, cancion.titulo)
            App30DiasFoto(cancion.imagen)
            App30DiasDescripcion(cancion.descripcion)
        }
    }
}

//Funcion para mostrar el dia y el título de esa actividad
@Composable
fun App30DiasDiaYTitulo(
    @StringRes dia: Int,
    @StringRes titulo: Int,
    modifier: Modifier = Modifier
){
    Column(modifier=modifier) {
        Text(
            text = stringResource(dia),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(titulo),
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
    }
}


//Funcion para mostrar la foto de la actividad
@Composable
fun App30DiasFoto(
    @DrawableRes foto: Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .fillMaxWidth()
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(foto),
        contentDescription = null)
}

//Funcion para mostrar la descripcion de la actividad
@Composable
fun App30DiasDescripcion(
    @StringRes descripcion: Int,
    modifier: Modifier = Modifier
){
    Column(modifier=modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)) {
        Text(
            text = stringResource(descripcion),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.padding_small))
        )
    }
}

//Funcion para mostrar la barra superior de la aplicacion
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App30DiasBarraSuperior(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(title ={
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    })
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    App30DiasTheme(darkTheme = false) {
        App30Dias()
    }
}

/*@Preview(showBackground = true)
@Composable
fun AppPreviewDark() {
    App30DiasTheme(darkTheme = true) {
        App30Dias()
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreviewItem() {
    App30DiasTheme {
        App30DiasBloque(Cancion(R.string.dia_1, R.string.cancion_1, R.drawable.nirvana, R.string.descripcion_1))
    }
}*/