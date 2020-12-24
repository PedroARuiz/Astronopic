package org.edrodev.astronopic.presentation.apod

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDate
import kotlinx.datetime.plus
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.datetime.today
import org.edrodev.astronopic.domain.model.Apod
import org.edrodev.astronopic.domain.useCase.GetApod
import org.edrodev.astronopic.presentation.core.Resource
import org.edrodev.astronopic.presentation.core.ViewModel
import org.edrodev.astronopic.presentation.core.toResource

class ApodViewModel(
    private val getApod: GetApod
) : ViewModel() {

    private val _date: MutableStateFlow<LocalDate> by lazy { MutableStateFlow(today()) }
    val date: StateFlow<LocalDate> by lazy { _date }

    val apod: Flow<Resource<Failure, Apod>> = date.flatMapConcat{ flowOf(
        Resource.Loading,
        getApod(it).toResource()
    ) }

    fun refresh() {
        date.value.also {  currentValue ->
            _date.value = LocalDate(0, 1, 1)
            _date.value = currentValue
        }
    }

    fun next() {
        _date.value = date.value.plus(DatePeriod(days = 1))
    }

    fun previous() {
        _date.value = date.value.plus(DatePeriod(days = -1))
    }

}