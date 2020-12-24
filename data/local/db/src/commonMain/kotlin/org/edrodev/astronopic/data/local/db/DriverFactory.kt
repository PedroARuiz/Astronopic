package org.edrodev.astronopic.data.local.db

import com.squareup.sqldelight.db.SqlDriver

internal expect class DriverFactory {
    fun createDriver(): SqlDriver
}