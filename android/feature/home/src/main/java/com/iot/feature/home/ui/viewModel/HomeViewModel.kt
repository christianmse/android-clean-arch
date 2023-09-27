package com.iot.feature.home.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iot.domain.usecase.GetSensorsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    getSensorsUseCase: GetSensorsUseCase
) : ViewModel() {

    sealed class HomeUiState(open val msg: String) {
        data object Loading : HomeUiState("Cargando")
        data class Sucess(override val msg: String) : HomeUiState(msg)
        data class Error(override val msg: String) : HomeUiState(msg)
    }

    val uiState: StateFlow<HomeUiState> = getSensorsUseCase.sensorsUiStateStream().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = HomeUiState.Loading
    )
}

private fun GetSensorsUseCase.sensorsUiStateStream(): Flow<HomeViewModel.HomeUiState> {
    return this()
        .map<String, HomeViewModel.HomeUiState> { HomeViewModel.HomeUiState.Sucess(it) }
        .onStart { emit(HomeViewModel.HomeUiState.Loading) }
        .catch { emit(HomeViewModel.HomeUiState.Error("Error")) }
}