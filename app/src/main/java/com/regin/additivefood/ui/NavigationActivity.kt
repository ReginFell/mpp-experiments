package com.regin.additivefood.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.regin.additivefood.R
import com.regin.additivefood.navigation.AacNavigator
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.NavigatorHolder

class NavigationActivity : AppCompatActivity() {

    private val navigatorHolder: NavigatorHolder by inject()

    private val navigator: AacNavigator by lazy {
        AacNavigator(this, R.id.navHost)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}