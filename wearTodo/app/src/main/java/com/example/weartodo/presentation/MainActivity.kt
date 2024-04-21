/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.weartodo.presentation

//import TodoListScreen
//import `TodoRepository.kt`
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val todos = Todo(id = "1", json = "{\"title\":\"Buy milk\",\"description\":\"Buy milk from the store\"}")

            val todoDao = TodoDatabase.getInstance(this@MainActivity).todoDao()
            val todoRepository = TodoRepository(todoDao)
            todoRepository.insert(todos)
            TodoList(todos = TodoDatabase.getInstance(this@MainActivity).todoDao().getAllTodos())
        }
    }
}

@Composable
fun TodoList(todos: List<Todo>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        todos.forEach { todo ->
            TodoItem(todo = todo)
        }
    }
}

@Composable
fun TodoItem(todo: Todo) {
    Text(
        todo.json,
        style = MaterialTheme.typography.bodyLarge
    )
}