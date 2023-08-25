package com.example.domain.di

import com.example.domain.usecase.gifs.GetAllGifsUseCase
import com.example.domain.usecase.gifs.GetGifDetailsUseCase
import org.koin.dsl.module

val domainModule = module {
    single {
        GetAllGifsUseCase(get())
    }
    single {
        GetGifDetailsUseCase(get())
    }
}