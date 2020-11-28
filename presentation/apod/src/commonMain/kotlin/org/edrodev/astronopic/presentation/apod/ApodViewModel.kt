package org.edrodev.astronopic.presentation.apod

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.datetime.today
import org.edrodev.astronopic.domain.model.Apod
import org.edrodev.astronopic.domain.useCase.GetApod
import org.edrodev.astronopic.presentation.core.Resource
import org.edrodev.astronopic.presentation.core.ViewModel

class ApodViewModel(
    private val getApod: GetApod
) : ViewModel() {

    private val date: MutableStateFlow<LocalDate> = MutableStateFlow(today())

    val apod: Flow<Resource<Failure, Apod>> = date.flatMapLatest { flow {
        emit(Resource.Loading)
        emit(Resource.Result(getApod(it)))
    } }

}