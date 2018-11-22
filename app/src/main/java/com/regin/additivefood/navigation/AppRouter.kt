package com.regin.additivefood.navigation

import ru.terrakok.cicerone.Router

class AppRouter : Router(), com.regin.additivefood.navigation.Router {

    override fun navigateTo(screen: Screen) {
        navigateTo(screen as ru.terrakok.cicerone.Screen)
    }

    override fun newRootScreen(screen: Screen) {
        newRootScreen(screen as ru.terrakok.cicerone.Screen)
    }

    override fun replaceScreen(screen: Screen) {
        replaceScreen(screen as ru.terrakok.cicerone.Screen)
    }

    override fun backTo(screen: Screen) {
        backTo(screen as ru.terrakok.cicerone.Screen)
    }
}