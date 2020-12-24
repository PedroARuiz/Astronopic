package org.edrodev.astronopic.data.remote.service

import org.edrodev.astronopic.core.Failure

sealed class NetworkFailure {
    object NotAvailable : NetworkFailure()
    object Unknown : NetworkFailure()
}

fun NetworkFailure.toFailure(): Failure = when(this) {
    NetworkFailure.NotAvailable -> Failure.NotFound
    NetworkFailure.Unknown -> Failure.Unknown
}

