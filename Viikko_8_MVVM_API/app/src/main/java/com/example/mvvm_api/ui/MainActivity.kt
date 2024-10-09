package com.example.mvvm_api.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvvm_api.model.Todo
import com.example.mvvm_api.ui.theme.MVVM_APITheme
import com.example.mvvm_api.viewmodel.TodoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    private val todoViewModel: TodoViewModel by viewModels()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVM_APITheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { contentPadding ->
                    TodoScreen(TodoViewModel(), contentPadding)
                }
            }
        }
    }
}

@Composable
fun TodoScreen(todoViewModel: TodoViewModel = viewModel(), contentPadding: PaddingValues = PaddingValues(16.dp)) {
    val todos = todoViewModel.todos
    TodoList(todos, contentPadding)
}

@Composable
fun TodoList(todos: List<Todo>, contentPadding: PaddingValues = PaddingValues(16.dp)) {
    LazyColumn(
        modifier = Modifier.padding(contentPadding)
    ) {
        items(todos.size) { todo ->
            Text(
                text = todos[todo].title,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            HorizontalDivider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    MVVM_APITheme {
        TodoScreen()
    }
}