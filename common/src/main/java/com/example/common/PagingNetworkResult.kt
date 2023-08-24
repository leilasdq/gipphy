package com.example.common

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.RemoteMediator
import kotlinx.coroutines.flow.map

fun <TType: Any, TResult : Any, TRemote : Any> pagingNetworkResult (
    config: PagingConfig,
    initialKey: TType? = null,
    pagingSourceFactory: () -> PagingSource<TType, TRemote>,
    mapToResult: (pagingData: PagingData<TRemote>) -> PagingData<TResult>,
    pageSize: Int = 15,
) = Pager(
    config = config,
    pagingSourceFactory = pagingSourceFactory,
    initialKey = initialKey,
).flow.map { pagingData -> mapToResult.invoke(pagingData) }