package com.example.data.di

import com.example.data.repository.gifs.GetGifsRepositoryImpl
import com.example.domain.usecase.gifs.GetGifsRepository
import com.example.remote.di.remoteModule
import org.koin.dsl.module

val dataModule = module {
    includes(remoteModule)
    single<GetGifsRepository> {
        GetGifsRepositoryImpl(get())
    }
}