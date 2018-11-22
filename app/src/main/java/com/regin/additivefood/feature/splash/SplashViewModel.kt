package com.regin.additivefood.feature.splash

import com.regin.additivefood.feature.home.HomeScreen
import com.regin.additivefood.ui.BaseViewModel
import kotlinx.coroutines.launch
import ru.terrakok.cicerone.Router

class SplashViewModel(
    private val splashUseCase: SplashUseCase
) : BaseViewModel() {

    init {
        launch {
            splashUseCase.start {}
    }
}}