package com.regin.additivefood.feature.home

import androidx.lifecycle.MutableLiveData
import com.regin.additivefood.data.additive.AdditiveRepository
import com.regin.additivefood.db.model.Additive
import com.regin.additivefood.ui.BaseViewModel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch

class HomeViewModel(private val additiveRepository: AdditiveRepository) : BaseViewModel() {

    val additiveLiveData: MutableLiveData<List<Additive>> = MutableLiveData()

    init {
        launch {
            additiveRepository.load().consumeEach {
                additiveLiveData.postValue(it)
            }
        }

    }
}