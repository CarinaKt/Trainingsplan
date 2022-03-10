package com.example.trainingsplan.feature_exercise.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.trainingsplan.feature_exercise.domain.model.Exercise


@Database(
    entities = [Exercise::class],
    version = 1
)
abstract class ExerciseDatabase: RoomDatabase() {

    abstract val exerciseDao: ExerciseDao

    companion object {
        const val DATABASE_NAME =  "exercise_db"
    }
}