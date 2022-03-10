package com.example.trainingsplan.feature_routine.domain.util

sealed class RoutineOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): RoutineOrder(orderType)
    class Date(orderType: OrderType): RoutineOrder(orderType)
    class Day(orderType: OrderType): RoutineOrder(orderType)
}
