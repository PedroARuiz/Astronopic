package org.edrodev.astronopic.core.datetime

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayAt

fun today(): LocalDate = Clock.System.todayAt(TimeZone.currentSystemDefault())