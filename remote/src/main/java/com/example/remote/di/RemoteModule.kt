package com.example.remote.di

import com.example.remote.serveceimpl.GetGifsServiceImpl
import com.example.remote.service.GetGifsService
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.http.*
import org.koin.dsl.module

val remoteModule = module {
    single {
        HttpClient {
            Logging {
                level = LogLevel.ALL
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                    }
                )
                this.acceptContentTypes = listOf(ContentType.Application.Json)
            }
        }
    }
    single<GetGifsService> {
        GetGifsServiceImpl(get())
    }
}