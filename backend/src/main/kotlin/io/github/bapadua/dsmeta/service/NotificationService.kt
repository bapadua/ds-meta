package io.github.bapadua.dsmeta.service

import io.github.bapadua.dsmeta.DateUtils
import io.github.bapadua.dsmeta.entity.Sale
import io.github.bapadua.dsmeta.enums.MessageTemplates
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class NotificationService(
    private val loggingService: LoggingService,
    private val smsService: SmsService,
    private val salesService: SalesService
) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun notification(uuid: UUID) {
        loggingService.logInfo(logger, "sending notification")
        val sale = salesService.findSale(uuid)
        notification(sale)
    }

    private fun notification(sale: Sale) {
        val date = DateUtils.getBrazilianFormatter(sale.date)
        val amount = sale.amount
        val sellerName = sale.sellerName
        val message = String.format(MessageTemplates.BEST_SELLER.getMessage(), sellerName, date, amount)
        notification(message)
    }

    private fun notification(message: String) {
        smsService.sendSms(message)
    }
}