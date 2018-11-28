package com.regin.additivefood.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.regin.additivefood.api.Api
import com.regin.additivefood.data.additive.AdditiveRepository
import com.regin.additivefood.ui.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(private val additiveRepository: AdditiveRepository) : BaseViewModel() {

     val additiveLiveData: LiveData<List<String>> = MutableLiveData()

    init {
        launch {
            additiveRepository.load()
        }

    }

    private fun loadAdditive() {

    }
}