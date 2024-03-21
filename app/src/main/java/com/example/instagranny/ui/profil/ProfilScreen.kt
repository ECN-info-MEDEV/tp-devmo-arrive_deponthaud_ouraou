package com.example.instagranny.ui.profil



import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun ProfilPreview() {
    ProfilPage(
        modifier= Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}


@Composable
fun ProfilPage(modifier : Modifier = Modifier) {
    val image = painterResource(id = com.example.instagranny.R.drawable.kin_personnes_agees)
    Column(modifier=modifier,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(
            text=stringResource(com.example.instagranny.R.string.votre_profil),
            textAlign = TextAlign.Center
        )
        Spacer(
            modifier=Modifier.height(16.dp)
        )
        RoundedImage(image = image)
        Spacer(
            modifier= Modifier.height(16.dp)
        )
        Text(
            text=stringResource(com.example.instagranny.R.string.photo_profil)
        )
        Spacer(
            modifier=Modifier.height(80.dp)
        )
        //ligne NOM
        Row(modifier=modifier)
        {Column() {
            Text(
                text=stringResource(com.example.instagranny.R.string.nom),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold)
        }
            Spacer(
                modifier=Modifier.width(16.dp)
            )
            Column() {
                Text(
                    text=stringResource(com.example.instagranny.R.string.nomvalue),)
            }
        }
        //ligneLOGIN
        Row(modifier=modifier)
        {Column() {
            Text(
                text=stringResource(com.example.instagranny.R.string.login),
                fontWeight = FontWeight.Bold)
        }
            Spacer(
                modifier=Modifier.width(16.dp)
            )
            Column() {
                Text(
                    text=stringResource(com.example.instagranny.R.string.loginvalue),)
            }
        }
        //ligneMAIL
        Row(modifier=modifier)
        {Column() {
            Text(
                text=stringResource(com.example.instagranny.R.string.mail),
                fontWeight = FontWeight.Bold)
        }
            Spacer(
                modifier=Modifier.width(16.dp)
            )
            Column() {
                Text(
                    text=stringResource(com.example.instagranny.R.string.mailvalue),)
            }
        }
        //ligneTEL
        Row(modifier=modifier)
        {Column() {
            Text(
                text=stringResource(com.example.instagranny.R.string.portable),
                fontWeight = FontWeight.Bold)
        }
            Spacer(
                modifier=Modifier.width(16.dp)
            )
            Column() {
                Text(
                    text=stringResource(com.example.instagranny.R.string.portablevalue),)
            }
        }
        //ligneBIO
        Row(modifier=modifier)
        {Column() {
            Text(
                text=stringResource(com.example.instagranny.R.string.bio),
                fontWeight = FontWeight.Bold)
        }
            Spacer(
                modifier=Modifier.width(16.dp)
            )
            Column() {
                Text(
                    text=stringResource(com.example.instagranny.R.string.biovalue),)
            }
        }
    }

}

@Composable
fun RoundedImage(image: Painter) {
    Box(
        modifier = Modifier
            .size(150.dp) // Taille de l'image
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