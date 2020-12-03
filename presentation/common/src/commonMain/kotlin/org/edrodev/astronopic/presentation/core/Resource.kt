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

fun <F, S>Resource<F, S>.successOrNull(): S? = (this as? Resource.Success)?.data

inline fun <F, S>Resource<F, S>.fold(
    onFailure: (F) -> Unit,
    onLoading: () -> Unit,
    onSuccess: (S) -> Unit,
) = when(this) {
    is Resource.Failure<F> -> onFailure(error)
    is Resource.Success<S> -> onSuccess(data)
    is Resource.Loading -> onLoading()
}

