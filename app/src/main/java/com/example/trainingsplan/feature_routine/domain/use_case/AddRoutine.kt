package com.example.trainingsplan.feature_routine.domain.use_case

import com.example.trainingsplan.feature_routine.domain.model.InvalidRoutineException
import com.example.trainingsplan.feature_routine.domain.model.Routine
import com.example.trainingsplan.feature_routine.domain.repository.RoutineRepository

class AddRoutine (
    private val repository: RoutineRepository
){
    @Throws(InvalidRoutineException::class)
    suspend operator fun invoke(routine: Routine){
        if (routine.title.isBlank()){
            throw InvalidRoutineException("The Nam eof the Routine can't be empty.")
        }
        if(routine.exercises.isEmpty()){
            throw InvalidRoutineException("A Routine needs at least one Exercise.")
        }
        repository.insertRoutine(routine)
    }
}