package com.example.weartodo.presentation

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weartodo.presentation.Todo

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(todo: Todo)

    @Query("SELECT * FROM todo")
    fun getAllTodos(): List<Todo>

    @Query("SELECT * FROM todo WHERE id = :id")
    fun getTodoById(id: String): Todo
}

