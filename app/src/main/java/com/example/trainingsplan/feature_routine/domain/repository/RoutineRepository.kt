package com.example.trainingsplan.feature_routine.domain.repository

import com.example.trainingsplan.feature_routine.domain.model.Routine
import kotlinx.coroutines.flow.Flow

interface RoutineRepository {

    fun getRoutines(): Flow<List<Routine>>

    suspend fun getRoutineById(id: Int): Routine?

    suspend fun insertRoutine(routine: Routine)

    suspend fun deleteRoutine(routine: Routine)
}