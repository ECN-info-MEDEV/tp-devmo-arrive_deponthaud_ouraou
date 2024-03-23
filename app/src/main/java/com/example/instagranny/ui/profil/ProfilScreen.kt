package com.example.instagranny.ui.profil



import android.text.Layout
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import androidx.wear.compose.material.dialog.Dialog


@Preview
@Composable
fun ProfilPreview() {
    val image = painterResource(id = com.example.instagranny.R.drawable.kin_personnes_agees)
    ProfilPage(modifier = Modifier, // Modifier pour spécifier la taille de la page
        image = painterResource(id = com.example.instagranny.R.drawable.kin_personnes_agees), // Image par défaut
        onImageClick = {
            // Action à effectuer lors du clic sur l'image
            // Par exemple, ouvrir la boîte de dialogue pour sélectionner une nouvelle image
            // ou effectuer toute autre action appropriée
        })
}

@Composable
fun ProfilPage(modifier : Modifier = Modifier,image: Painter, onImageClick: () -> Unit) {
    val image2 = painterResource(id = com.example.instagranny.R.drawable.kin_personnes_agees)
    var selectedImage by remember { mutableStateOf(image2) }
    var showImagePickerDialog by remember { mutableStateOf(false) }


    Column(modifier=modifier,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(com.example.instagranny.R.string.votre_profil),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier.height(34.dp)
            )
            RoundedImage(image = selectedImage)
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Text(
                text = stringResource(com.example.instagranny.R.string.photo_profil),
                fontStyle = Italic,
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { showImagePickerDialog = true }
            )
            }
        Spacer(
            modifier = Modifier.height(45.dp))

        Row(modifier = Modifier.weight(1f)) {
            Spacer(
                modifier = Modifier.width(16.dp)
            )
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {

                //ligne NOM
                Row(modifier = Modifier)
                {
                    Text(
                        text = stringResource(com.example.instagranny.R.string.nom),
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )}
                Spacer(modifier = Modifier.height(15.dp))
                //ligne LOGIN
                    Row(modifier = Modifier)
                    {
                        Text(
                            text = stringResource(com.example.instagranny.R.string.login),
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold
                        )
                    }
                Spacer(modifier = Modifier.height(15.dp))
                    //ligne MAIL
                    Row(modifier = Modifier)
                    {
                        Text(
                            text = stringResource(com.example.instagranny.R.string.mail),
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold
                        )
                    }
                Spacer(modifier = Modifier.height(15.dp))
                    //ligne PHONE
                    Row(modifier = Modifier)
                    {
                        Text(
                            text = stringResource(com.example.instagranny.R.string.portable),
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold
                        )
                    }
                Spacer(modifier = Modifier.height(15.dp))
                    //ligne BIO
                    Row(modifier = Modifier)
                    {
                        Text(
                            text = stringResource(com.example.instagranny.R.string.bio),
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            Column( //COLUMN of values
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                //ligne NOM value
                Row(modifier = Modifier)
                {
                        Text(
                            text = stringResource(com.example.instagranny.R.string.nomvalue),
                        )
                    }
                Spacer(modifier = Modifier.height(15.dp))
                //ligneLOGIN value
                Row(modifier = Modifier)
                {
                   Text(
                            text = stringResource(com.example.instagranny.R.string.loginvalue),
                        )
                    }
                Spacer(modifier = Modifier.height(15.dp))
                //ligneMAIL value
                Row(modifier = Modifier)
                {
                        Text(
                            text = stringResource(com.example.instagranny.R.string.mailvalue),
                        )
                    }
                Spacer(modifier = Modifier.height(15.dp))
                //ligneTEL value
                Row(modifier = Modifier)
                {
                    Text(
                            text = stringResource(com.example.instagranny.R.string.portablevalue),
                        )
                    }
                Spacer(modifier = Modifier.height(15.dp))
                //ligneBIO value
                Row(modifier = Modifier)
                {
                        Text(
                            text = stringResource(com.example.instagranny.R.string.biovalue),
                        )
                    }
                }
            }
        }
    //Boîte de dialogue de sélection d'image
    if (showImagePickerDialog) {
        ImagePickerDialog(
            onDismiss = { showImagePickerDialog = false },
            onImageSelected = { image ->
                selectedImage = image
                showImagePickerDialog = false
            }
        )
    }
    }

@Composable
fun ImagePickerDialog(onDismiss: () -> Unit, onImageSelected: (Painter) -> Unit) {
    val images = listOf(
        com.example.instagranny.R.drawable.kin_personnes_agees,
        com.example.instagranny.R.drawable.tuto_photographier_un_coucher_de_soleil_plage
        // Ajoutez ici d'autres références aux images disponibles dans le dossier drawable
    )

    // Backdrop for the dialog
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .clickable(onClick = onDismiss),
        contentAlignment = Alignment.Center
    ) {
        // Dialog content
        Card(
            modifier = Modifier.padding(16.dp),
            //elevation = 8.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Sélectionnez une nouvelle photo")

                Spacer(modifier = Modifier.height(16.dp))

                // Affichage des images disponibles
                images.forEach { image ->
                    val painter = painterResource(id = image)
                    Image(
                        painter = painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(4.dp)
                            .clickable { onImageSelected(painter) }
                    )
                }
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
/*
    @Composable
    fun ChangeLoginButton(
        @StringRes labelResourceId: Int,
        onClick: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Button(
            onClick = onClick,
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text(stringResource(labelResourceId))
        }
    }*/
