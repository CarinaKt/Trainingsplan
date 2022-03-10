package com.example.trainingsplan.feature_routine.domain.use_case

import com.example.trainingsplan.feature_routine.domain.model.Routine
import com.example.trainingsplan.feature_routine.domain.repository.RoutineRepository

class DeleteRoutine(
    private val repository: RoutineRepository
) {

    suspend operator fun invoke (routine: Routine){
        repository.deleteRoutine(routine)
    }
}