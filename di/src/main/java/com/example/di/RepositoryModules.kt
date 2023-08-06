package com.example.di

import com.example.data.di.dataModule
import org.koin.dsl.module

val repositoryModule = module {
    includes(dataModule)
}