package org.example.cmphelloworld.core.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.example.cmphelloworld.core.data.HttpClientEngineFactory
import org.example.cmphelloworld.todo.data.KtorTodoRepository
import org.example.cmphelloworld.todo.di.todoModule
import org.example.cmphelloworld.todo.domain.TodoRepository
import org.example.cmphelloworld.todo.presentation.TodoViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class AppModule {

    // This is Default Usage if only i base url
    @Single
    fun httpClient(engine: HttpClientEngine): HttpClient = HttpClient(engine) {

    }

    // example you have two different base api url that auth and no auth
    @Single
    @AuthHttpClient
    fun authHttpClient(engine: HttpClientEngine): HttpClient = HttpClient(engine) {

    }

    @AuthHttpClient
    fun noAuthHttpClient(engine: HttpClientEngine): HttpClient = HttpClient(engine) {

    }

    @Factory
    fun httpClientEngine(): HttpClientEngine = HttpClientEngineFactory().getHttpEngine()

    init {
        todoModule()
    }
}

annotation class AuthHttpClient
annotation class NoAuthHttpClient