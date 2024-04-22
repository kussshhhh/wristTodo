package com.example.weartodo.presentation

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weartodo.presentation.Todo

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // can be used for update too ?
    suspend fun insertTodo(todo: Todo)

    @Query("SELECT * FROM todos")
    fun getAllTodos(): LiveData<List<Todo>>

    @Query("SELECT * FROM todos WHERE id = :id")
    fun getTodoById(id: String): Todo
}

