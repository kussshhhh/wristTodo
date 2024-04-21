package com.example.weartodo.presentation

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weartodo.presentation.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        private const val DATABASE_NAME = "todo_database"

        @Volatile
        private var INSTANCE: TodoDatabase? = null

        fun getInstance(context: Context): TodoDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): TodoDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                TodoDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}