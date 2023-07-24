package com.example.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

fun<TRemote, TDomainData> networkResult(
    remoteCall: suspend () -> TRemote,
    mapToDomain: suspend (TRemote) -> TDomainData
) = flow<GetResult<TDomainData>> {
    emit(GetResult.Loading(true))

    val serverData = remoteCall.invoke()
    emit(GetResult.Success(mapToDomain(serverData)))
}.catch {
    emit(GetResult.Error(throwable = it))
}.flowOn(Dispatchers.IO).cancellable()