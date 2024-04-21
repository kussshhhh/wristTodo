package com.example.weartodo.presentation
import com.example.weartodo.presentation.Todo

class TodoRepository(private val todoDao: TodoDao) {
    val allTodos: List<Todo> = todoDao.getAllTodos()

    fun insert(todo: Todo) {
        todoDao.insertTodo(todo)
    }

    fun getTodoById(id: String): Todo? {
        return todoDao.getTodoById(id)
    }
}