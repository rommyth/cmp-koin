package org.example.cmphelloworld.todo.di

import io.ktor.client.HttpClient
import org.example.cmphelloworld.core.di.AppModule
import org.example.cmphelloworld.core.di.AuthHttpClient
import org.example.cmphelloworld.todo.data.KtorTodoRepository
import org.example.cmphelloworld.todo.domain.TodoRepository
import org.example.cmphelloworld.todo.presentation.TodoViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module


fun todoModule() {

    @Factory(binds = [TodoRepository::class])
    fun todoRepository(httpClient: HttpClient) = KtorTodoRepository(httpClient)

    // Some route need auth
    // @Factory(binds = [TodoRepository::class])
    // fun todoRepository(@AuthHttpClient httpClient: HttpClient) = KtorTodoRepository(httpClient)

    // Some route no need auth
    // @Factory(binds = [TodoRepository::class])
    // fun todoRepository(@NoAuthHttpClient httpClient: HttpClient) = KtorTodoRepository(httpClient)

    @KoinViewModel
    fun todoViewModel(todoRepository: TodoRepository) = TodoViewModel(todoRepository)
}