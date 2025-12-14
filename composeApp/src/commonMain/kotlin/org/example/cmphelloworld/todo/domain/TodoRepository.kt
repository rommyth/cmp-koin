package org.example.cmphelloworld.todo.domain

interface TodoRepository {
    suspend fun getTodos(): List<String>
}