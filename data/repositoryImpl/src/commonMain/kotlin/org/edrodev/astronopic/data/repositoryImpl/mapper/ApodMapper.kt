package org.edrodev.astronopic.data.repositoryImpl.mapper

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.domain.model.Apod

import org.edrodev.astronopic.data.remote.dto.ApodDTO
import orgedrodevastronopicdatalocaldb.ApodEntity

fun ApodDTO.toApod() : Apod = Apod(
    date = LocalDate.parse(date),
    title = title,
    explanation = explanation,
    url = url,
    hdurl = hdurl,
    copyright = copyright,
)

fun ApodEntity.toApod() : Apod = Apod(
    date = LocalDate.parse(date),
    title = title,
    explanation = explanation,
    url = url,
    hdurl = hdurl,
    copyright = copyright,
)

fun ApodDTO.toApodEntity() : ApodEntity = ApodEntity(
    date = date,
    title = title,
    explanation = explanation,
    url = url,
    hdurl = hdurl,
    copyright = copyright,
)
