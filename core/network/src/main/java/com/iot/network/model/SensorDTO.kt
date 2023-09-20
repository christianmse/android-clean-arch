package com.iot.network.model

import com.iot.model.SensorBO
import kotlinx.serialization.Serializable

/**
 * Network representation of [SensorBO]
 */
@Serializable
internal data class SensorDTO(
    val id: String
)
