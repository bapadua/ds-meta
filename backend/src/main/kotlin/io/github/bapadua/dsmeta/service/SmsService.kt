package io.github.bapadua.dsmeta.service

import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class SmsService(
    private val loggingService: LoggingService,
) {
    @Value("\${twilio.active}")
    private var active: Boolean? = false
    @Value("\${twilio.sid}")
    private lateinit var twilioSid: String
    @Value("\${twilio.key}")
    private lateinit var twilioKey: String
    @Value("\${twilio.phone.from}")
    private lateinit var twilioPhoneFrom: String
    @Value("\${twilio.phone.to}")
    private lateinit var twilioPhoneTo: String

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun sendSms(message: String) {
        if(active == true) {
            Twilio.init(twilioSid, twilioKey)
            val from = PhoneNumber(twilioPhoneFrom)
            val to = PhoneNumber(twilioPhoneTo)
            val result = Message.creator(to, from, message).create()
            loggingService.logInfo(logger, "message sent to ${twilioPhoneTo}: sid: ${result.sid}")
        } else
            loggingService.logInfo(logger, "fake message sent to $twilioPhoneTo")

    }

}