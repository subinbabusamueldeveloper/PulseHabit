package com.pulsehabit.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pulsehabit.db.dao.GlucoseEntryDao
import com.pulsehabit.db.entity.GlucoseEntryEntity


@Database(
    entities = [GlucoseEntryEntity::class],
    version = 1,
    exportSchema = true
)
abstract class PulseHabitDatabase : RoomDatabase() {
    abstract fun glucoseEntryDao(): GlucoseEntryDao
}