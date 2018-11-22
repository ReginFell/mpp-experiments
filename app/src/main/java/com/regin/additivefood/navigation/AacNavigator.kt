package com.regin.additivefood.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.commands.*

open class AacNavigator(private val activity: FragmentActivity, navFragmentId: Int) : Navigator {

    private val navController: NavController

    init {
        val navFrag = activity.supportFragmentManager.findFragmentById(navFragmentId)
        if (navFrag is NavHostFragment) {
            navController = navFrag.navController
        } else {
            throw IllegalArgumentException("No NavHostFragment found at given FragmentActivity." + " Please make sure you don't forget to add it!")
        }
    }

    override fun applyCommands(commands: Array<Command>) {
        for (command in commands) {
            applyCommand(command)
        }
    }
    private fun applyCommand(command: Command) {
        when (command) {
            is Forward -> fragmentForward(command.screen)
            is Replace -> fragmentReplace(command.screen)
            is BackTo -> fragmentBackTo(command.screen)
            is Back -> fragmentBack()
        }
    }

    private fun fragmentReplace(screen: Screen) {
        fragmentBack()
        fragmentForward(screen)
    }

    private fun fragmentForward(screen: Screen) {
        val aacScreen = checkScreenInstance(screen)
        navController.navigate(
            aacScreen.navigationResId,
            aacScreen.args,
            aacScreen.navOptions, aacScreen.navExtras
        )
    }

    private fun fragmentBack() {
        if (!navController.popBackStack()) {
            activity.finish()
        }
    }

    private fun fragmentBackTo(screen: Screen) {
        val aacScreen = checkScreenInstance(screen)
        navController.popBackStack(aacScreen.navigationResId, false)
    }

    private fun checkScreenInstance(screen: Screen): AacScreen {
        if (screen is AacScreen) {
            return screen
        }
        throw IllegalArgumentException("Screen should be instance of AacScreen!")
    }
}