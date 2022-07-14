package io.github.bapadua.dsmeta.controller

import io.github.bapadua.dsmeta.entity.Sale
import io.github.bapadua.dsmeta.service.SalesService
import io.github.bapadua.dsmeta.service.LoggingService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

private const val RETRO_DATE_LIMIT_MONTHS = 1L

@RestController
@RequestMapping("/sales")
class SalesController(
    private val loggingService: LoggingService,
    private val salesService: SalesService
) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping
    fun getSales(
        @RequestParam(value = "start", defaultValue = "") startDate: String,
        @RequestParam(value = "end", defaultValue = "") endDate: String,
        page: Pageable
    ): ResponseEntity<Page<Sale>> {
        loggingService.logInfo(logger, "get sales")
        val maxDate = getDate(endDate)
        val minDate = getDate(startDate, true)
        return ResponseEntity.ok(
            salesService.findSales(
                minDate,
                maxDate,
                page
            )
        )
    }

    private fun getDate(date: String?): LocalDate {
        if (date == null || date.isBlank()) {
            return LocalDate.now()
        }
        return LocalDate.parse(date)
    }

    private fun getDate(date: String?, past: Boolean?): LocalDate {
        if ((date == null || date.isBlank()) && past == true) {
            return LocalDate.now().minusMonths(RETRO_DATE_LIMIT_MONTHS)
        }
        return LocalDate.parse(date)
    }

}