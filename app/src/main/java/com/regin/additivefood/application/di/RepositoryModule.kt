package com.regin.additivefood.application.di

import com.regin.additivefood.data.additive.AdditiveRepository
import org.koin.dsl.module.module

val repositoryModule = module {
    single { AdditiveRepository(get(), get()) }
}