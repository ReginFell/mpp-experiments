package com.regin.additivefood.feature.splash

import com.regin.additivefood.feature.home.HomeScreen
import com.regin.additivefood.navigation.AppRouter
import com.regin.additivefood.ui.BaseViewModel
import kotlinx.coroutines.launch

class SplashViewModel(
    private val splashUseCase: SplashUseCase,
    private val router: AppRouter
) : BaseViewModel() {

    init {
        launch {
            splashUseCase.start {
                router.navigateTo(HomeScreen)
            }
        }
    }
}