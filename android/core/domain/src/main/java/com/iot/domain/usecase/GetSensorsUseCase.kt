package com.iot.domain.usecase

import com.iot.data.repository.SensorsRepository

class GetSensorsUseCase(
    private val sensorsRepository: SensorsRepository
) {
}