package io.github.bapadua.dsmeta.service

import io.github.bapadua.dsmeta.entity.Sale
import io.github.bapadua.dsmeta.repository.SalesRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SalesService(
    private val salesRepository: SalesRepository,
    private val loggingService: loggingService
    ) {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun findSales(): MutableList<Sale> {
        loggingService.logInfo(logger, "get all sales")
        return salesRepository.findAll()
    }
}