package com.example.instagranny.ui.amis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AmisViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is amis Fragment"
    }
    val text: LiveData<String> = _text
}