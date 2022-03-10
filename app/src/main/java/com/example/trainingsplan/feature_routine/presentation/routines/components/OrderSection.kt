package com.example.trainingsplan.feature_routine.presentation.routines.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.trainingsplan.feature_routine.domain.util.OrderType
import com.example.trainingsplan.feature_routine.domain.util.RoutineOrder

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: RoutineOrder= RoutineOrder.Day(OrderType.Descending),
    onOrderChange: (RoutineOrder) -> Unit
) {

}