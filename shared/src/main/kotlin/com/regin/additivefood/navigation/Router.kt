package com.regin.additivefood.navigation

interface Router {

    fun navigateTo(screen: Screen)

    fun newRootScreen(screen: Screen)

    fun replaceScreen(screen: Screen)

    fun backTo(screen: Screen)

    fun finishChain()

    fun exit()

}