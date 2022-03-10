package com.example.trainingsplan.feature_routine.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.trainingsplan.feature_exercise.domain.model.Exercise
import java.lang.Exception

@Entity
data class Routine(
    val title: String,
    val timeStamp: Long,
    val day: Int, // defines the training order
    val exercises: List<Exercise>,
    // TODO: val exercise: Exercise -> List
    @PrimaryKey val id: Int? = null
) {
  // companion object
}

class InvalidRoutineException(message:String): Exception(message)

/*
@Entity
data class Exercises(
 val name: String,
 val image: Picture? = null,
 val sets: List<Set>? = null,
    @PrimaryKey val id: Int? = null
)

@Entity
data class Set(
    val wdh : Int,
    val kg: Double,
    val order: Int,
    val dropSet: Boolean,
    @PrimaryKey val id: Int? = null
)*/
