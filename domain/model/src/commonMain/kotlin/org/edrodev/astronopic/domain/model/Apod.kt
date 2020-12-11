package org.edrodev.astronopic.domain.model

import kotlinx.datetime.LocalDate

data class Apod(
    val copyright: String? = null,
    val date: LocalDate,
    val explanation: String,
    val hdurl: String?,
    val title: String,
    val url: String
)