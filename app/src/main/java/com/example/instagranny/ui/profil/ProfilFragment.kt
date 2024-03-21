package com.example.instagranny.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.instagranny.databinding.FragmentProfilBinding
import androidx.compose.ui.Modifier

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ProfilPage(modifier = Modifier,
                    //modifier = Modifier.fillMaxSize(), // Modifier pour spécifier la taille de la page
                    image = painterResource(id = com.example.instagranny.R.drawable.kin_personnes_agees), // Image par défaut
                    onImageClick = {
                        // Action à effectuer lors du clic sur l'image
                        // Par exemple, ouvrir la boîte de dialogue pour sélectionner une nouvelle image
                        // ou effectuer toute autre action appropriée
                    }
            )

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}