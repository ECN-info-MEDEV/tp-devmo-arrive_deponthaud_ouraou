package com.example.instagranny.ui.profil



import android.text.Layout
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import com.example.instagranny.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import androidx.wear.compose.material.dialog.Dialog
import com.example.instagranny.ui.InstaUiState
import com.example.instagranny.ui.InstaViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instagranny.ui.accueil.RoundedImage
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun ProfilPreview() {
    val image = painterResource(id = R.drawable.kin_personnes_agees)
    ProfilPage(modifier = Modifier, // Modifier pour spécifier la taille de la page
        instaViewModel= viewModel(),
        onImageClick = {
            // Action à effectuer lors du clic sur l'image
            // Par exemple, ouvrir la boîte de dialogue pour sélectionner une nouvelle image
            // ou effectuer toute autre action appropriée
        })
}

@Composable
fun ProfilPage(
    modifier : Modifier = Modifier,
    instaViewModel: InstaViewModel,
    onImageClick: () -> Unit) {

    val resources = LocalContext.current.resources
    val instaUiState by instaViewModel.uiState.collectAsState()
    var selectedImage = painterResource(instaUiState.adresseAvatar)
    var showImagePickerDialog by remember { mutableStateOf(false) }
    var isLoginFieldVisible by remember { mutableStateOf(false) }
    val loginvalue = instaUiState.profilNom
    var LoginInput by remember { mutableStateOf(loginvalue) }

        Column(modifier=modifier,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(34.dp)
            )
            Text(
                text = stringResource(R.string.bonjour) +instaUiState.profilNom,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize=30.sp
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
                modifier = Modifier.weight(3f),
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
                modifier = Modifier.weight(3f),
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
                    if (isLoginFieldVisible) {
                        TextField(
                                value = LoginInput,
                                onValueChange ={ newLoginValue:String -> LoginInput = newLoginValue},
                                //value = textState.value,
                                //onValueChange = { textState.value = it },
                                //singleLine = true,
                                modifier = Modifier
                                //KeyboardOptions.Default.copy(imeAction = ImeAction.Done)

                         )
                        instaViewModel.newProfilName(LoginInput)
                    }
                    else{
                   Text(
                       //text = stringResource(com.example.instagranny.R.string.loginvalue),
                       text=LoginInput
                        )
                    }}
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
            //COLUMN TO EDIT
            Column(modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier=Modifier.height(36.dp))
                Row(modifier = Modifier)
                {
                    if (isLoginFieldVisible) {
                        /*Image(
                            painter = painterResource(R.drawable.ok),
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp)
                                .clickable { isLoginFieldVisible = false }
                        )*/
                        Text(
                            text="OK",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .size(30.dp)
                                .clickable { isLoginFieldVisible = false }
                        )
                    }
                    else{
                    Image(
                        painter = painterResource(R.drawable.edit),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { isLoginFieldVisible = true }
                    )}
                }
            }
            }
        }
    //Boîte de dialogue de sélection d'image
    if (showImagePickerDialog) {
        ImagePickerDialog(
            onDismiss = { showImagePickerDialog = false },
            instaViewModel=instaViewModel,
            onImageSelected = { image ->
                selectedImage = image
                showImagePickerDialog = false
            },
        )
    }
    }

@Composable
fun ImagePickerDialog(onDismiss: () -> Unit, onImageSelected: (Painter) -> Unit,instaViewModel:InstaViewModel = viewModel()) {
    val images = listOf(
        R.drawable.kin_personnes_agees,
        R.drawable.tuto_photographier_un_coucher_de_soleil_plage,
        R.drawable.profil1,
        R.drawable.profil2,
        R.drawable.profil3,
        R.drawable.profil4,
        R.drawable.profil5,
        R.drawable.profil6,
        // Ajoutez ici d'autres références aux images disponibles dans le dossier drawable
    )
    // Calcul du nombre de colonnes en fonction de la largeur de l'écran
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val columnWidth = 100.dp // Largeur souhaitée de chaque image
    val numColumns = (screenWidth / columnWidth).toInt()

    // Division des images en lignes avec le nombre approprié de colonnes
    val rows = images.chunked(numColumns)

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
                // Affichage des lignes d'images
                rows.forEach { rowImages ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        rowImages.forEach { image ->
                            val painter = painterResource(id = image)
                            Image(
                                painter = painter,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(4.dp)
                                    .clickable {
                                        onImageSelected(painter)
                                        instaViewModel.newAvatar(image)
                                    }
                            )
                        }
                    }
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