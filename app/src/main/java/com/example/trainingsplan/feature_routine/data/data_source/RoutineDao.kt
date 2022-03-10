package com.example.trainingsplan.feature_routine.data.data_source

import androidx.room.*
import com.example.trainingsplan.feature_routine.domain.model.Routine
import kotlinx.coroutines.flow.Flow

@Dao
interface RoutineDao {

    @Query("SELECT * FROM `routine`")
    fun getPlans(): Flow<List<Routine>>

    @Query("SELECT * FROM `routine` WHERE id = :id")
    suspend fun getPlanById(id: Int): Routine?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlan(routine: Routine)

    @Delete
    suspend fun deletePlan(routine: Routine)
}