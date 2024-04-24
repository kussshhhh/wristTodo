package com.example.weartodo.presentation
import androidx.lifecycle.LiveData
import com.example.weartodo.presentation.Todo

class TodoRepository(private val todoDao : TodoDao){
    val getAllTodos: LiveData<List<Todo >> = todoDao.getAllTodos()

    suspend fun insertTodo(todo : Todo){
        todoDao.insertTodo(todo)

    }
}

