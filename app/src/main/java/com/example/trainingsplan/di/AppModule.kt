package com.example.trainingsplan.di

import android.app.Application
import androidx.room.Room
import com.example.trainingsplan.feature_routine.data.data_source.RoutineDatabase
import com.example.trainingsplan.feature_routine.data.repository.RoutineRepositoryImpl
import com.example.trainingsplan.feature_routine.domain.repository.RoutineRepository
import com.example.trainingsplan.feature_routine.domain.use_case.AddRoutine
import com.example.trainingsplan.feature_routine.domain.use_case.DeleteRoutine
import com.example.trainingsplan.feature_routine.domain.use_case.GetRoutines
import com.example.trainingsplan.feature_routine.domain.use_case.RoutineUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): RoutineDatabase {
        return  Room.databaseBuilder(
            app,
            RoutineDatabase::class.java,
            RoutineDatabase.DATABASE_NAME
        ).build()
    }


    @Provides
    @Singleton
    fun provideRoutineRepository(db: RoutineDatabase): RoutineRepository {
        return RoutineRepositoryImpl(db.routineDao)
    }

    @Provides
    @Singleton
    fun provideRoutineUseCase(repository: RoutineRepository): RoutineUseCases {
        return RoutineUseCases(
            getRoutines = GetRoutines(repository),
            deleteRoutine = DeleteRoutine(repository),
            addRoutine = AddRoutine(repository)
        )
    }
}