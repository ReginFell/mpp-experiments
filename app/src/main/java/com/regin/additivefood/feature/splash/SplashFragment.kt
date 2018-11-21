package com.regin.additivefood.feature.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import org.koin.android.viewmodel.ext.android.getViewModel

class SplashFragment : Fragment() {

    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadModule()
        splashViewModel = getViewModel()
    }
}