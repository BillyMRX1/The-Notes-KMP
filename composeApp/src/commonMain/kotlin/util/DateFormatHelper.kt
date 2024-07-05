package util

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

expect object DateFormatHelper {
    fun getFormattedDate(
        iso8601Timestamp: Long,
        format: String
    ): String
}

fun getCurrentTimeAsLong(): Long {
    val currentInstant: Instant = Clock.System.now()
    return currentInstant.toEpochMilliseconds()
}