package com.pulsehabit.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "glucose_entries")
data class GlucoseEntryEntity(
    @PrimaryKey val id: String,
    val valueTenthsMmolL: Long,
    val variant: String,
    val dayEpochMillis: Long,
    val recordedAtEpochMillis: Long,
    val createdAtEpochMillis: Long,
    val updatedAtEpochMillis: Long,
    val isDeleted: Boolean
)