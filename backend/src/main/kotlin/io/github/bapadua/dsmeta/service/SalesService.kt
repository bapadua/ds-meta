package io.github.bapadua.dsmeta.service

import io.github.bapadua.dsmeta.entity.Sale
import io.github.bapadua.dsmeta.repository.SalesRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class SalesService(
    private val salesRepository: SalesRepository,
    private val loggingService: LoggingService
    ) {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun findSales(minDate: LocalDate, maxDate: LocalDate, page: Pageable): Page<Sale> {
        loggingService.logInfo(logger, "get all sales")
        return salesRepository.findSales(minDate, maxDate, page)
    }
}