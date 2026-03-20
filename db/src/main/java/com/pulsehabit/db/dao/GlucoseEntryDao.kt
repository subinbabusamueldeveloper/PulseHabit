package com.pulsehabit.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.pulsehabit.db.entity.GlucoseEntryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GlucoseEntryDao {

    @Query("""
        SELECT * FROM glucose_entries
        WHERE variant = :variant AND isDeleted = 0
        ORDER BY recordedAtEpochMillis DESC
    """)
    fun observeEntries(variant: String): Flow<List<GlucoseEntryEntity>>

    @Upsert
    suspend fun upsert(entity: GlucoseEntryEntity)

    @Query("""
        UPDATE glucose_entries
        SET isDeleted = 1, updatedAtEpochMillis = :updatedAtEpochMillis
        WHERE id = :id
    """)
    suspend fun softDeleteById(id: String, updatedAtEpochMillis: Long)
}