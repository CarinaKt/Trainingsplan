package com.example.trainingsplan.feature_exercise.domain.model

import android.graphics.Picture
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Exercise(
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
)