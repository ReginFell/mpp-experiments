package com.regin.additivefood.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import ru.terrakok.cicerone.Screen

abstract class AacScreen : Screen() {

    @get:IdRes
    abstract val navigationResId: Int

    val args: Bundle?
        get() = null

    val navOptions: NavOptions?
        get() = null

    val navExtras: Navigator.Extras?
        get() = null
}