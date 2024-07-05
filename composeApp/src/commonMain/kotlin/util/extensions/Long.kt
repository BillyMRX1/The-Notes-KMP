package util.extensions

import util.DateFormatHelper.getFormattedDate

fun Long?.toStringFormat(): String {
    if (this == null) return ""
    return getFormattedDate(this, "dd MMM yyyy, HH:mm")
}