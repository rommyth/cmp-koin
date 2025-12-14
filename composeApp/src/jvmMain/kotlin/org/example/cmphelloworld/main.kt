package org.example.cmphelloworld

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.cmphelloworld.core.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CMPHelloWorld",
        ) {
            App()
        }
    }
}