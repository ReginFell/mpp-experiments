package com.regin.additivefood.data.additive

import com.regin.additivefood.api.Api
import com.regin.additivefood.api.model.toAdditive
import com.regin.additivefood.db.AdditiveDao
import com.regin.additivefood.db.model.Additive
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel

class AdditiveRepository(
    private val api: Api,
    private val additiveDao: AdditiveDao
) {

    suspend fun load(): BroadcastChannel<List<Additive>> {
        val channel = ConflatedBroadcastChannel<List<Additive>>()

        val additives = api.loadAdditives().await().map { it.toAdditive() }

        channel.offer(additives)
        additiveDao.insert(additives)

        return channel
    }
}