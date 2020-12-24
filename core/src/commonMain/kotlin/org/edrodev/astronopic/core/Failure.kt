package org.edrodev.astronopic.core

sealed class Failure {
    object NotFound : Failure()
    object Unknown : Failure()
}