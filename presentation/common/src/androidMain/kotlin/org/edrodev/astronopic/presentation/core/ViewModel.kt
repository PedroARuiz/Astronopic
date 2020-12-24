package org.edrodev.astronopic.presentation.core

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual open class ViewModel : androidx.lifecycle.ViewModel() {
    protected actual val vmScope: CoroutineScope by lazy {
        viewModelScope
    }
}
