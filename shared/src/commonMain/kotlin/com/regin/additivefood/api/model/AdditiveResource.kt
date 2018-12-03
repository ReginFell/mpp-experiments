package com.regin.additivefood.api.model

import com.regin.additivefood.db.model.Additive
import kotlinx.serialization.Serializable

@Serializable
data class AdditiveResource(val id: String, val name: String)

internal fun AdditiveResource.toAdditive() = Additive.Impl(
    id = this.id,
    name = this.name
)