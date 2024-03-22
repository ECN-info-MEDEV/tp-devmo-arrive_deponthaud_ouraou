package com.example.instagranny.ui.amis

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagranny.ui.profil.ProfilPage


@Composable
fun AmisPage(modifier:Modifier=Modifier){
    Column(modifier=Modifier
    ){
        EnteteAmis(
            onSearchTextChanged={},
            onFilterClicked={}
        )
        Ami(nomId=com.example.instagranny.R.string.NomAmi,image=painterResource(com.example.instagranny.R.drawable.kin_personnes_agees))
    }

}

@Composable
fun EnteteAmis(modifier:Modifier=Modifier,
        onSearchTextChanged: (String) -> Unit,
        onFilterClicked: () -> Unit){

    Column(modifier){
        Text(
            text=stringResource(com.example.instagranny.R.string.liste_amis)
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = TextFieldValue(stringResource(com.example.instagranny.R.string.rechercher)),
                onValueChange = { onSearchTextChanged(it.text) },
                singleLine = true,
                //textStyle = MaterialTheme.typography.body1.copy(color = Color.Black),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )
            IconButton(
                onClick = onFilterClicked,
                modifier = Modifier.size(48.dp)
            ) {
                Image(
                    painter = painterResource(com.example.instagranny.R.drawable.imagefiltre),
                    contentDescription = stringResource(id = com.example.instagranny.R.string.filter_icon)
                )
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text="Photo"
            )
            Text(
                text="Amis"
            )
            Text(
                text="Gérer l'amitié"
            )
        }
        }
    }


@Composable
fun Ami(
    modifier: Modifier = Modifier,
    @StringRes nomId: Int,
    image: Painter
) {
    Row(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RoundedImage(image)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stringResource(nomId),
            modifier = Modifier.weight(1f) // Utiliser Modifier.weight pour répartir l'espace restant
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {  },
            modifier = Modifier
                .weight(0.5f) // Utiliser Modifier.weight pour répartir l'espace restant
                .widthIn(min = 250.dp) // Largeur minimale pour le bouton
                .padding(horizontal = 8.dp, vertical = 4.dp), // Ajouter un espacement intérieur au bouton
             // Modifier la couleur de fond du bouton
            shape = RoundedCornerShape(8.dp) // Définir la forme du bouton
        ) {
            Text(
                text = stringResource(com.example.instagranny.R.string.boutton_suppression_amis),
                fontSize = 12.sp // Modifier la taille et le style de la police
            )
        }
    }
}

@Composable
fun RoundedImage(image: Painter) {
    Box(
        modifier = Modifier
            .size(60.dp) // Taille de l'image
            .clip(RoundedCornerShape(75.dp)) // Rayon du cercle
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
@Preview
@Composable
fun AmisPreview() {
    AmisPage(
        modifier= Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}


