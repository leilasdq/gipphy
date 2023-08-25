package com.example.gipphyapplication.di

import com.example.gipphyapplication.ui.gifdetail.GifsDetailViewModel
import com.example.gipphyapplication.ui.gifsList.GifsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModule = module {
    viewModel { GifsListViewModel(get()) }
    viewModel { GifsDetailViewModel(get()) }
}