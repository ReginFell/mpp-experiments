package com.regin.additivefood.feature.splash

import android.util.Log
import com.regin.additivefood.ui.BaseViewModel
import kotlinx.coroutines.launch

class SplashViewModel(private val splashUseCase: SplashUseCase) : BaseViewModel() {

    init {
        launch {
            splashUseCase.start {
                Log.i("One one one", "this is test")
            }
        }
    }
}