package org.edrodev.astronopic.core

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach

class PruebaKMP {
    val value = 1

    val myFlow: Flow<Int> = flowOf(1,2,3,4).onEach { delay(500) }
    suspend fun mySuspend(): Int {
        delay(500)
        return 3
    }
}