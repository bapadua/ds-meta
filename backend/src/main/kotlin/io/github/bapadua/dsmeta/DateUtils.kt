package io.github.bapadua.dsmeta

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateUtils {
    companion object {
        private const val brazilianFormat = "dd/MM/yyyy"
        private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern(brazilianFormat)

        fun getBrazilianFormatter(date: LocalDate): String? {
            return formatter.format(date)
        }
    }
}