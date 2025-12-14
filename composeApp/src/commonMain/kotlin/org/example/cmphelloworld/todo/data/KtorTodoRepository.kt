package org.example.cmphelloworld.todo.data

import io.ktor.client.HttpClient
import org.example.cmphelloworld.todo.domain.TodoRepository
import org.koin.core.annotation.Single


class KtorTodoRepository(
    private val httpClient: HttpClient
): TodoRepository {

    override suspend fun getTodos(): List<String> {
        return (1..10).map {
            "Todo $it"
        }
    }

}