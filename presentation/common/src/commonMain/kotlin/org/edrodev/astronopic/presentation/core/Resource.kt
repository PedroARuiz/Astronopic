package org.edrodev.astronopic.presentation.core

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.edrodev.astronopic.core.Result as CoreResult

sealed class Resource<out F, out S> {
    object Loading : Resource<Nothing, Nothing>()
    data class Result<F, S>(val result: CoreResult<F, S>): Resource<F, S>()
}

/*
fun <F, S>resourceFlow(block: suspend () -> CoreResult<F, S>): Flow<Resource<F, S>> = flow {
    emit(Resource.Loading)
    emit(Resource.Result(block))
}*/
