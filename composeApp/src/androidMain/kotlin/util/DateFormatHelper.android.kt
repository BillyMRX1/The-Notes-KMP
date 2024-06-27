package util

import java.text.SimpleDateFormat
import java.util.Locale

actual object DateFormatHelper {
    actual fun getFormattedDate(
        iso8601Timestamp: Long,
        format: String
    ): String {
        val dateFormat = SimpleDateFormat(format, Locale.US)

        return dateFormat.format(iso8601Timestamp)
    }
}