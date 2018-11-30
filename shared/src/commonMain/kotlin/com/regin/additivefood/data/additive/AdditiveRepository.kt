package com.regin.additivefood.data.additive

import com.regin.additivefood.api.Api
import com.regin.additivefood.db.AdditiveDao

class AdditiveRepository(
    private val api: Api,
    private val additiveDao: AdditiveDao
) {

    suspend fun load() {
        val additives = api.loadAdditives().await()

        additiveDao.insert(additives)
    }
}