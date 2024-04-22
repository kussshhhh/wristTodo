package com.example.weartodo.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application){
    private val getAllTodos: LiveData<List<Todo>>
    private val repository: TodoRepository

    init {
        val todoDao = TodoDatabase.getDatabase(application).todoDao()
        repository = TodoRepository(todoDao)
        getAllTodos = repository.getAllTodos
    }

    fun insertTodo(todo: Todo){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertTodo(todo)
        }
    }

}
