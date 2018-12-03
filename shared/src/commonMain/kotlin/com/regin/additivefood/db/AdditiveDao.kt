package com.regin.additivefood.db

import com.regin.additivefood.db.model.Additive

class AdditiveDao(queryWrapper: QueryWrapper) {

    private val db = queryWrapper.additiveQueries

     internal fun insert(items: List<Additive>) {
        db.transaction {
            for (item in items) {
                insert(item)
            }
        }
    }

    internal fun insert(item: Additive) {
        db.insertItem(
            id = item.id,
            name = item.name
        )
    }
}