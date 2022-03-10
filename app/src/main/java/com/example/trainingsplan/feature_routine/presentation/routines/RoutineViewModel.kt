package com.example.trainingsplan.feature_routine.presentation.routines

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingsplan.feature_routine.domain.model.Routine
import com.example.trainingsplan.feature_routine.domain.use_case.RoutineUseCases
import com.example.trainingsplan.feature_routine.domain.util.OrderType
import com.example.trainingsplan.feature_routine.domain.util.RoutineOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RoutinesViewModel @Inject constructor(
    private val routinesUseCases: RoutineUseCases
) : ViewModel(){

    private val _state = mutableStateOf(RoutineState())
    val state: State<RoutineState> = _state

    private var recentlyDeletedRoutine: Routine? = null

    private var getRoutineJob: Job? = null

    // my not need later, because first thing to load on start ar plans
    init {
        getRoutine(RoutineOrder.Day(OrderType.Descending))
    }

    fun onEvent(event: RoutinesEvent) {
        when(event) {
            is RoutinesEvent.Order -> {
                if (state.value.routineOrder::class == event.routineOrder::class &&
                        state.value.routineOrder.orderType == event.routineOrder.orderType) {
                            return
                }
                getRoutine(event.routineOrder)
            }
            is RoutinesEvent.DeleteRoutine -> {
                viewModelScope.launch {
                    routinesUseCases.deleteRoutine(event.routine)
                    recentlyDeletedRoutine = event.routine
                }
            }

            is RoutinesEvent.RestoreRoutine -> {
                viewModelScope.launch {
                    routinesUseCases.addRoutine(recentlyDeletedRoutine ?: return@launch)
                    recentlyDeletedRoutine = null
                }
            }

            is RoutinesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getRoutine(routineOrder: RoutineOrder){
        getRoutineJob?.cancel()
        routinesUseCases.getRoutines(routineOrder)
            .onEach { routines ->
                _state.value = state.value.copy(
                    routes = routines,
                    routineOrder = routineOrder
                )
            }
            .launchIn(viewModelScope)
    }
}