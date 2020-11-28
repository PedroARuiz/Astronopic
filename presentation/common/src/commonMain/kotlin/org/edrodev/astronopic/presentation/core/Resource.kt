package org.edrodev.astronopic.presentation.core

sealed class Resource<out F, out S> {
    object Loading : Resource<Nothing, Nothing>()
    data class Success<S>(val data: S): Resource<Nothing, S>()
    data class Failure<F>(val error: F): Resource<F, Nothing>()
}

fun <S>S.asSuccess(): Resource<Nothing, S> = Resource.Success(this)
fun <F>F.asFailure(): Resource<F, Nothing> = Resource.Failure(this)

val <F, S>Resource<F, S>.isSuccess: Boolean get() = this is Resource.Success
val <F, S>Resource<F, S>.isFailure: Boolean get() = this is Resource.Failure
val <F, S>Resource<F, S>.isLoading: Boolean get() = this is Resource.Loading

/*
fun <F, S>resourceFlow(block: suspend () -> CoreResult<F, S>): Flow<Resource<F, S>> = flow {
    emit(Resource.Loading)
    emit(Resource.Result(block))
}*/
