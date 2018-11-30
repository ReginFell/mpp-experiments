package com.regin.additivefood.db

import com.regin.additivefood.api.model.AdditiveResource

class AdditiveDao(private val queryWrapper: QueryWrapper) {

    private val db = queryWrapper.additiveQueries

    suspend fun insert(items: List<AdditiveResource>) {
        db.transaction {
            for (item in items) {
                val affected = db.insertItem(item.title)
            }
        }
    }

    suspend fun insert(item: AdditiveResource) {
        db.insertItem(
            title = item.title
        )
    }

}