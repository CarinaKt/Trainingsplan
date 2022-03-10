package com.example.trainingsplan.feature_routine.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
