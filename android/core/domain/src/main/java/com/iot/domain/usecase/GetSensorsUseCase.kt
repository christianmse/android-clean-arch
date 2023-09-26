package com.iot.domain.usecase

import com.iot.data.repository.SensorsRepository
import kotlinx.coroutines.flow.Flow

class GetSensorsUseCase(
    private val sensorsRepository: SensorsRepository
) {
    operator fun invoke(): Flow<String> {
        return sensorsRepository.sensorsStream
    }
}