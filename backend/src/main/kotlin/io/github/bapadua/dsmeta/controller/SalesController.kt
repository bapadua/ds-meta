package io.github.bapadua.dsmeta.controller

import io.github.bapadua.dsmeta.entity.Sale
import io.github.bapadua.dsmeta.service.SalesService
import io.github.bapadua.dsmeta.service.loggingService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sales")
class SalesController(
    private val loggingService: loggingService,
    private val salesService: SalesService
) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping
    fun getSales(): ResponseEntity<MutableList<Sale>> {
        loggingService.logInfo(logger, "get sales")
        return ResponseEntity.ok(salesService.findSales())
    }
}