package com.app.weatherapplication.core.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun String.toCustomDateFormat(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd MMMM", Locale("tr"))

    val date = inputFormat.parse(this)
    return outputFormat.format(date)
}


fun String.convertToNormalTimeFormat(): String {

    val time = this.toIntOrNull() ?: return "Geçersiz saat değeri"

    val hour = time / 100
    val minute = (time % 10000) / 100
    val second = time % 100

    val cal = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, hour)
        set(Calendar.MINUTE, minute)
        set(Calendar.SECOND, second)
    }

    val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())

    return formatter.format(cal.time)
}