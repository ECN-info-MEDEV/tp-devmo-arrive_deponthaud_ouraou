package com.example.instagranny.ui.amis

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagranny.ui.profil.ProfilPage


@Composable
fun AmisPage(modifier:Modifier=Modifier){
    var searchQuery by remember { mutableStateOf("") }
    Column(modifier=Modifier
        .statusBarsPadding()
        .padding(horizontal = 40.dp)
        .verticalScroll(rememberScrollState())
    ){
        EnteteAmis(
            onFilterClicked={},
            searchQuery= searchQuery,
            onSearchTextChanged ={searchQuery=it}
        )
        Ami(nomId=com.example.instagranny.R.string.NomAmi,image=com.example.instagranny.R.drawable.kin_personnes_agees)
    }

}

@Composable
fun EnteteAmis(modifier:Modifier=Modifier,
                onFilterClicked: () -> Unit,
               onSearchTextChanged: (String) -> Unit,
                searchQuery: String){

    Column(modifier,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text=stringResource(com.example.instagranny.R.string.liste_amis),
            textAlign = TextAlign.Center,
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchBar(
                label=com.example.instagranny.R.string.rechercher,
                leadingIcon = com.example.instagranny.R.drawable.imagefiltre,
                value=searchQuery,
                onValueChange=onSearchTextChanged,
                modifier=Modifier.padding(bottom=32.dp).fillMaxWidth()
            )

        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text=stringResource(id=com.example.instagranny.R.string.photos_amis),
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier.requiredWidth(15.dp)
            )
            Text(
                text=stringResource(id=com.example.instagranny.R.string.nom_amis),
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier.requiredWidth(25.dp)
            )
            Text(
                text=stringResource(id=com.example.instagranny.R.string.gerer_amitie),
                fontWeight = FontWeight.Bold
            )
        }
        Divider(color = Color.Gray, thickness = 1.dp)
        }
    }


@Composable
fun Ami(
    modifier: Modifier = Modifier,
    @StringRes nomId: Int,
    @DrawableRes image: Int
) {
    Row(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RoundedImage(painterResource(image))
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
                .padding(horizontal = 4.dp, vertical = 0.dp), // Ajouter un espacement intérieur au bouton
             // Modifier la couleur de fond du bouton
            shape = RoundedCornerShape(8.dp) // Définir la forme du bouton
        ) {
            Text(
                text = stringResource(com.example.instagranny.R.string.boutton_suppression_amis),
                fontSize = 10.sp // Modifier la taille et le style de la police
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


@Composable
fun SearchBar(
    @StringRes label:Int,
    @DrawableRes leadingIcon:Int,
    value:String,
    onValueChange:(String)->Unit,
    modifier:Modifier=Modifier){
    TextField(
        value=value,
        leadingIcon={Icon(painterResource(id=leadingIcon),null)},
        onValueChange=onValueChange,
        modifier=modifier,
        label={Text(stringResource(label))},
        singleLine=true,
    )


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


