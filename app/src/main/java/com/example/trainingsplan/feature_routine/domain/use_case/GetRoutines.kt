package com.example.trainingsplan.feature_routine.domain.use_case

import com.example.trainingsplan.feature_routine.domain.model.Routine
import com.example.trainingsplan.feature_routine.domain.repository.RoutineRepository
import com.example.trainingsplan.feature_routine.domain.util.OrderType
import com.example.trainingsplan.feature_routine.domain.util.RoutineOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetRoutines(
    private val repository: RoutineRepository
){

    operator fun invoke(
        routineOrder: RoutineOrder = RoutineOrder.Day(OrderType.Descending)
    ): Flow<List<Routine>> {
        return repository.getRoutines().map { plans ->
            when(routineOrder.orderType){
                is OrderType.Ascending -> {
                    when(routineOrder){
                        is RoutineOrder.Day -> plans.sortedBy { it.day }
                        is RoutineOrder.Date -> plans.sortedBy { it.timeStamp }
                        is RoutineOrder.Title -> plans.sortedBy {it.title}
                    }
                }
                is OrderType.Descending ->{
                    when(routineOrder){
                        is RoutineOrder.Day -> plans.sortedByDescending { it.day }
                        is RoutineOrder.Date -> plans.sortedByDescending { it.timeStamp }
                        is RoutineOrder.Title -> plans.sortedByDescending {it.title}
                    }
                }
            }
        }
    }
}