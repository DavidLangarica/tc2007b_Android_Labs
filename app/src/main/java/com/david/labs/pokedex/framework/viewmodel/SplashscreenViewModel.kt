package com.david.labs.pokedex.framework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.labs.pokedex.utils.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashscreenViewModel:ViewModel() {
    val finishedLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        finishedLoading.postValue(false)
        viewModelScope.launch {
            delay(Constants.SPLASHSCREEN_DURATION)
            finishedLoading.postValue(true)
        }
    }
}