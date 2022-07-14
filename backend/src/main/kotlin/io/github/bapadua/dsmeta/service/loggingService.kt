package io.github.bapadua.dsmeta.service

import org.slf4j.Logger
import org.springframework.stereotype.Component

@Component
class loggingService {

    fun logInfo(logger: Logger, message: String) {
        logger.info(message)
    }
}