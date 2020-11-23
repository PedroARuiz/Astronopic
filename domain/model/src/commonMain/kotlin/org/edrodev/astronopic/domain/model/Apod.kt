package org.edrodev.astronopic.domain.model

import kotlinx.datetime.LocalDateTime

data class Apod(
    val copyright: String? = null,
    val date: LocalDateTime,
    val explanation: String,
    val hdurl: String,
    val mediaType: String? = null,
    val title: String,
    val url: String
)