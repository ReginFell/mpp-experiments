package com.regin.additivefood.data.additive

import com.regin.additivefood.api.Api
import com.regin.additivefood.db.QueryWrapper

class AdditiveRepository(
    private val api: Api,
    private val queryWrapper: QueryWrapper

) {

    suspend fun load() {
        val result = api.loadAdditives().await()

        queryWrapper.additiveQueries.insertItem(result)
    }
}