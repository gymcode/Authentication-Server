package com.gymcode

import com.gymcode.core.plugins.configureHTTP
import com.gymcode.core.plugins.configureRouting
import com.gymcode.core.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.gymcode.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureHTTP()
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
