package com.example.trainingsplan.feature_routine.presentation.routines

import com.example.trainingsplan.feature_routine.domain.model.Routine
import com.example.trainingsplan.feature_routine.domain.util.RoutineOrder

sealed class RoutinesEvent {
    data class Order(val routineOrder: RoutineOrder): RoutinesEvent()
    data class DeleteRoutine(val routine: Routine): RoutinesEvent()
    object RestoreRoutine: RoutinesEvent()
    object ToggleOrderSection: RoutinesEvent() // May not needed in my case

}
