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
import org.json.JSONObject


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val todoDao = TodoDatabase.getInstance(this@MainActivity).todoDao()

        val todo1 = Todo(id = "1", json = "{\"title\":\"Buy milk\",\"description\":\"Buy milk from the store\"}")
        val todo2 = Todo(id = "2", json = "{\"title\":\"Buy eggs\",\"description\":\"Buy eggs from the store\"}")

        todoDao.insertTodo(todo1)
        todoDao.insertTodo(todo2)
        setContent {
            val sheesh = TodoDatabase.getInstance(this@MainActivity).todoDao()
            val todoRepository = TodoRepository(sheesh)
            val todos = todoRepository.allTodos

            TodoList(todos = todos)
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
    val jsonObject = JSONObject(todo.json)
    val title = jsonObject.getString("title")
    val description = jsonObject.getString("description")

    Text(
        text = "$title: $description",
        style = MaterialTheme.typography.bodyLarge
    )
}