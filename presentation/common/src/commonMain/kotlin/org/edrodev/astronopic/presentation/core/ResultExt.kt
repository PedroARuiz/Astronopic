package org.edrodev.astronopic.presentation.core

import org.edrodev.astronopic.core.Result

fun <F, S>Result<F, S>.toResource(): Resource<F, S> = when(this) {
    is Result.Success -> data.asSuccess()
    is Result.Failure -> error.asFailure()
}