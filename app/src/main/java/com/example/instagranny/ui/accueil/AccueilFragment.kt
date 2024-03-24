package com.example.instagranny.ui.accueil

import android.os.Bundle
import android.text.Layout.Alignment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.instagranny.databinding.FragmentAccueilBinding
import com.example.instagranny.databinding.FragmentProfilBinding
import com.example.instagranny.ui.InstaViewModel
import com.example.instagranny.ui.profil.ProfilPage

class AccueilFragment : Fragment() {

    private var _binding: FragmentAccueilBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val instaViewModel: InstaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAccueilBinding.inflate(inflater, container, false)
        val view = binding.root
        // Ne pas ajouter ComposeView à une vue existante, setContent remplace la vue existante par votre ComposeView
        val composeView = ComposeView(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setContent {
                AccueilPage(modifier= Modifier.fillMaxSize()
                    .padding(0.dp),
                    instaViewModel=instaViewModel,
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
