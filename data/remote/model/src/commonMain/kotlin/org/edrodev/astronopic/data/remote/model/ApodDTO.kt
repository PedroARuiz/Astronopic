package org.edrodev.astronopic.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class ApodDTO(
    val copyright: String? = null,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val mediaType: String? = null,
    val title: String,
    val url: String
)