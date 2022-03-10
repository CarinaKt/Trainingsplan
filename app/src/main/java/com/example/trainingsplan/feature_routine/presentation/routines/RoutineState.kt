package com.example.trainingsplan.feature_routine.presentation.routines

import com.example.trainingsplan.feature_routine.domain.model.Routine
import com.example.trainingsplan.feature_routine.domain.util.OrderType
import com.example.trainingsplan.feature_routine.domain.util.RoutineOrder

data class RoutineState(
    val routes: List<Routine> = emptyList(),
    val routineOrder: RoutineOrder = RoutineOrder.Day(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
