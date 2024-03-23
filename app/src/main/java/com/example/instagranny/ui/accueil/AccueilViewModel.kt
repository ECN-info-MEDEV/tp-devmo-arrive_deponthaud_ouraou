package com.example.instagranny.ui.accueil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccueilViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is accueil Fragment"
    }
    val text: LiveData<String> = _text

}