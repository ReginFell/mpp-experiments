package com.regin.additivefood.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.regin.additivefood.R
import com.regin.additivefood.feature.splash.SplashFragment

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.navContainer, SplashFragment())
                .commitNow()
        }

    }
}