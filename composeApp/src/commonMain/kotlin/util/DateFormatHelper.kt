package util

expect object DateFormatHelper {
    fun getFormattedDate(
        iso8601Timestamp: Long,
        format: String
    ): String
}