package com.example.trainingsplan.feature_routine.data.repository

import com.example.trainingsplan.feature_routine.data.data_source.RoutineDao
import com.example.trainingsplan.feature_routine.domain.model.Routine
import com.example.trainingsplan.feature_routine.domain.repository.RoutineRepository
import kotlinx.coroutines.flow.Flow

class RoutineRepositoryImpl(
    private val dao: RoutineDao
) : RoutineRepository {
    override fun getRoutines(): Flow<List<Routine>> {
       return dao.getPlans()
    }

    override suspend fun getRoutineById(id: Int): Routine? {
       return dao.getPlanById(id)
    }

    override suspend fun insertRoutine(routine: Routine) {
        dao.insertPlan(routine)
    }

    override suspend fun deleteRoutine(routine: Routine) {
        dao.deletePlan(routine)
    }
}