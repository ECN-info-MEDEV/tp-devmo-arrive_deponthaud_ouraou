package com.example.instagranny.ui.accueil

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instagranny.R
import com.example.instagranny.ui.InstaViewModel


@Composable
fun AccueilPage(modifier : Modifier = Modifier, instaViewModel:InstaViewModel) {
    val instaUiState by instaViewModel.uiState.collectAsState()
    Column(modifier=Modifier
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ){
        Row{
            Image(
                painter = painterResource(id = R.drawable.logo_instagram),
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .padding(15.dp)
                    .weight(0.7f)
            )
            Box (modifier = Modifier.padding(10.dp).weight(0.2f)){
                RoundedImage(painterResource(instaUiState.adresseAvatar), 60.dp)
            }
        }
        Divider(color = Color.Gray, thickness = 1.dp)
        Row (modifier=Modifier.fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.Start)
        {
            val taille: Dp = 60.dp
            Box (modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp)) {
                RoundedImage(painterResource(id = R.drawable.profil1), taille)
            }
            Box (modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp)) {
                RoundedImage(painterResource(id = R.drawable.profil2), taille)
            }
            Box (modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp)) {
                RoundedImage(painterResource(id = R.drawable.profil3), taille)
            }
            Box (modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp)) {
                RoundedImage(painterResource(id = R.drawable.profil4), taille)
            }
            Box (modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp)) {
                RoundedImage(painterResource(id = R.drawable.profil5), taille)
            }
            Box (modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp)) {
                RoundedImage(painterResource(id = R.drawable.profil6), taille)
            }

        }
        Divider(color = Color.Gray, thickness = 1.dp)
        Row (modifier=modifier.padding(15.dp)){
            Box(modifier = modifier.align(Alignment.Top)
                .padding(start = 10.dp, end=5.dp)
                .weight(0.2f)
            ){
                val taille: Dp = 40.dp
                RoundedImage(painterResource(id = R.drawable.profil3), taille)
            }
            Column(modifier=modifier.weight(1f)) {
                Text("Camille dans Famille")
                Text(text="il y a 2 jours",
                    fontStyle = FontStyle.Italic)

                Image(
                    painterResource(id = R.drawable.publication1),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                        .clip(RoundedCornerShape(10))
                        .padding(top=5.dp, bottom=5.dp)
                )
                Text("Jacqueline a commenté :")
                Box(modifier=modifier.padding(start=15.dp)
                ){
                    Text("Beurk...")
                }
                Spacer(
                    modifier=Modifier.width(8.dp)
                )
                Row (modifier=modifier,
                ){
                    Button(
                        onClick = {},
                        modifier = modifier.weight(0.4f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified, contentColor = Color.Black),

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.like),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Text("Aimer", modifier=modifier.padding(start=4.dp))
                    }
                    Button(
                        onClick = {},
                        modifier = modifier.weight(0.5f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified, contentColor = Color.Black),

                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.comment),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Text("Commenter", modifier=modifier.padding(start=6.dp,top=3.dp))
                    }

                }


            }

        }
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = modifier.padding(start = 80.dp, end=20.dp)
        )
        Row (modifier=modifier.padding(15.dp)){
            Box(modifier = modifier.align(Alignment.Top)
                .padding(start = 10.dp, end=5.dp)
                .weight(0.2f)
            ){
                val taille: Dp = 40.dp
                RoundedImage(painterResource(id = R.drawable.profil4), taille)
            }
            Column(modifier=modifier.weight(1f)) {
                Text("Serge dans Famille")
                Text(text="il y a 2 jours",
                    fontStyle = FontStyle.Italic)

                Image(
                    painterResource(id = R.drawable.publication2),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                        .clip(RoundedCornerShape(10))
                        .padding(top=5.dp, bottom=5.dp)
                )
                Text("Jacqueline a commenté :")
                Box(modifier=modifier.padding(start=15.dp)
                ){
                    Text("Beurk...")
                }
                Spacer(
                    modifier=Modifier.width(8.dp)
                )
                Row (modifier=modifier,
                ){
                    Button(
                        onClick = {},
                        modifier = modifier.weight(0.4f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified, contentColor = Color.Black),

                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.like),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Text("Aimer", modifier=modifier.padding(start=4.dp))
                    }
                    Button(
                        onClick = {},
                        modifier = modifier.weight(0.5f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified, contentColor = Color.Black),

                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.comment),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Text("Commenter", modifier=modifier.padding(start=6.dp,top=3.dp))
                    }

                }


            }

        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfilPreview() {
    AccueilPage(
        modifier= Modifier
            .fillMaxSize(),
        instaViewModel=viewModel()
    )
}

@Composable
fun RoundedImage(image: Painter, taille: Dp) {
    Box(
        modifier = Modifier
            .size(taille) // Taille de l'image
            .clip(RoundedCornerShape(taille/2)) // Rayon du cercle
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}