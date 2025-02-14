package com.eshaq.kharidino.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * From item")
    fun getAllItems(): Flow<List<Item>>

    @Insert
    suspend fun insertItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)

    @Update
    suspend fun buyFlagItem(item: Item)

    @Update
    suspend fun buyAllItems ()

    @Delete
    suspend fun deleteItem(item: Item)

    @Delete
    suspend fun deleteAllItems()
}