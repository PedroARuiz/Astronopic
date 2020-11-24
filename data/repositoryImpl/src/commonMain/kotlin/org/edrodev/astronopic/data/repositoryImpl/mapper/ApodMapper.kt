package org.edrodev.astronopic.data.repositoryImpl.mapper

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.domain.model.Apod

import org.edrodev.astronopic.data.remote.dto.ApodDTO

fun ApodDTO.toApod() : Apod = Apod(
    date = LocalDate.parse(date),
    title = title,
    explanation = explanation,
    url = url,
    hdurl = hdurl,
    copyright = copyright,
)
