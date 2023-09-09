package com.example.gipphyapplication.di

import com.example.gifitemdetail.ui.GifsDetailViewModel
import com.example.giflist.ui.GifsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModule = module {
    viewModel { GifsListViewModel(getAllGifsUseCase = get()) }
    viewModel { GifsDetailViewModel(getGifDetailsUseCase = get(), gifId = get()) }
}