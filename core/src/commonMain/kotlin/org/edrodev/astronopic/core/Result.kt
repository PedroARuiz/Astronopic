package org.edrodev.astronopic.core

sealed class Result<out F, out S> {
    data class Success<S>(val data: S) : Result<Nothing, S>()
    data class Failure<F>(val error: F) : Result<F, Nothing>()
}

fun <S>S.asSuccess(): Result<Nothing, S> = Result.Success(this)
fun <F>F.asFailure(): Result<F, Nothing> = Result.Failure(this)

fun <F, S, S2>Result<F, S>.mapSuccess(map: (S) -> S2) : Result<F, S2> = when(this) {
    is Result.Success<S> -> map(data).asSuccess()
    is Result.Failure<F> -> error.asFailure()
}

inline fun <F, S>Result<F, S>.ifSuccess(block: (S) -> Unit) : Result<F, S> {
    if(this is Result.Success<S>) {
        block(data)
    }

    return this
}

fun <F, S, F2>Result<F, S>.mapFailure(map: (F) -> F2) : Result<F2, S> = when(this) {
    is Result.Success<S> -> data.asSuccess()
    is Result.Failure<F> -> map(error).asFailure()
}

fun <F, S>Result<F, S>.successOrThrow(): S = if(this is Result.Success<S>) {
    data
} else throw IllegalStateException("data is null")

fun <F, S>Result<F, S>.failureOrThrow(): F = if (this is Result.Failure<F>){
    error
} else throw IllegalStateException("error is null")

fun <S>runCatchingFailure(block: () -> S) : Result<Failure, S> = try {
    block().asSuccess()
} catch (e: Exception) {
    Failure().asFailure()
}