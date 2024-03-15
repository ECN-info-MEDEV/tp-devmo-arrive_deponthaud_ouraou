package com.example.instagranny.ui.amis

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.instagranny.databinding.FragmentAmisBinding

class AmisFragment : Fragment() {

    private var _binding: FragmentAmisBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val amisViewModel =
            ViewModelProvider(this).get(AmisViewModel::class.java)

        _binding = FragmentAmisBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAmis
        amisViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}