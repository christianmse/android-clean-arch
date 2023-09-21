package com.iot.feature.home.ui.viewModel

import androidx.lifecycle.ViewModel
import com.iot.domain.usecase.GetSensorsUseCase

class HomeViewModel(
    private val getSensorsUseCase: GetSensorsUseCase
): ViewModel() {

}