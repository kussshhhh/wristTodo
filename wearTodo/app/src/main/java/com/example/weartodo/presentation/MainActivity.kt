/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.weartodo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.wear.compose.material.MaterialTheme
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
//import androidx.compose.ui.platform.setContent
import com.example.weartodo.presentation.Todo
import com.example.weartodo.presentation.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Prepopulate the database with 2 todos
        val todo1 = Todo("1", "{\"title\":\"Buy milk\",\"description\":\"Buy milk from the store\"}")
        val todo2 = Todo("2", "{\"title\":\"Buy eggs\",\"description\":\"Buy eggs from the store\"}")

        val viewModel = TodoViewModel(application)
        viewModel.insertTodo(todo1)
        viewModel.insertTodo(todo2)

        // Display the todos using Compose UI
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    viewModel.getAllTodos.value?.forEach { todo ->
                        TodoItem(todo)
                    }
                }
            }
        }
    }
}

@Composable
fun TodoItem(todo: Todo) {
    Text(
        text = todo.json,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(vertical = 4.dp)
    )
}