package com.regin.additivefood.application.di

import com.regin.additivefood.db.AdditiveDao
import com.regin.additivefood.db.QueryWrapper
import com.squareup.sqldelight.android.AndroidSqlDatabase
import org.koin.dsl.module.module

val databaseModule = module {
    single {
        QueryWrapper(
            AndroidSqlDatabase(QueryWrapper.Schema, get(), getProperty("databaseName"))
        )
    }
    single { AdditiveDao(get()) }
}