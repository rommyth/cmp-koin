package org.example.cmphelloworld.todo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.cmphelloworld.todo.domain.TodoRepository

class TodoViewModel(
    private val repository: TodoRepository
): ViewModel() {

    private val _state = MutableStateFlow(emptyList<String>())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val todos = repository.getTodos()
            _state.update { todos }
        }
    }
}