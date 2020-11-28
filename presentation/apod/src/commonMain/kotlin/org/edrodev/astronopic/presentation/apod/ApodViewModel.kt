package org.edrodev.astronopic.presentation.apod

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
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

@ExperimentalCoroutinesApi
class ApodViewModel(
    private val getApod: GetApod
) : ViewModel() {

    private val date: MutableStateFlow<LocalDate> = MutableStateFlow(today())

    val apod: Flow<Resource<Failure, Apod>> = date.flatMapLatest { flow {
        emit(Resource.Loading)

        emit(getApod(it).toResource())
    } }

    fun refresh() {
        date.value.also {  currentValue ->
            date.value = LocalDate(0, 1, 1)
            date.value = currentValue
        }
    }

    fun next() {
        date.value = date.value.plus(DatePeriod(days = 1))
    }

    fun previous() {
        date.value = date.value.plus(DatePeriod(days = -1))
    }

}