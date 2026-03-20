package com.pulsehabit.app.core.di

import android.content.Context
import androidx.room.Room
import com.pulsehabit.db.dao.GlucoseEntryDao
import com.pulsehabit.db.database.PulseHabitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providePulseHabitDatabase(
        @ApplicationContext context: Context
    ): PulseHabitDatabase {
        return Room.databaseBuilder(
            context,
            PulseHabitDatabase::class.java,
            "pulse_habit.db"
        ).build()
    }

    @Provides
    fun provideGlucoseEntryDao(
        database: PulseHabitDatabase
    ): GlucoseEntryDao {
        return database.glucoseEntryDao()
    }
}