package com.example.domain.di

import com.example.domain.usecase.gifs.GetAllGifsUseCase
import org.koin.dsl.module

val domainModule = module {
    single {
        GetAllGifsUseCase(get())
    }
}