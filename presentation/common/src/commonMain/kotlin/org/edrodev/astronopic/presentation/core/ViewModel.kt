package org.edrodev.astronopic.presentation.core

import kotlinx.coroutines.CoroutineScope

expect open class ViewModel() {
    protected val vmScope: CoroutineScope
}