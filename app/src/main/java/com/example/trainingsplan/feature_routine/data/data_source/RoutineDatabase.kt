package com.example.trainingsplan.feature_routine.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.trainingsplan.feature_routine.domain.model.Routine

@Database(
    entities = [Routine::class],
    version = 1
)
abstract class RoutineDatabase: RoomDatabase() {

    abstract val routineDao: RoutineDao

    companion object {
        const val DATABASE_NAME =  "routine_db"
    }
}