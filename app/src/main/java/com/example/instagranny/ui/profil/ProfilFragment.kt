package com.example.instagranny.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.instagranny.ui.InstaViewModel
import com.example.instagranny.ui.accueil.AccueilPage

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val instaViewModel: InstaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        val view = binding.root
        // Ne pas ajouter ComposeView à une vue existante, setContent remplace la vue existante par votre ComposeView
        val composeView = ComposeView(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setContent {
                ProfilPage(
                    modifier = Modifier,
                    instaViewModel=instaViewModel,
                    onImageClick = {
                        // Action à effectuer lors du clic sur l'image
                        // Par exemple, ouvrir la boîte de dialogue pour sélectionner une nouvelle image
                        // ou effectuer toute autre action appropriée
                    }
                )
            }
        }
        return composeView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}