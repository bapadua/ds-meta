package io.github.bapadua.dsmeta.enums

enum class MessageTemplates {
    BEST_SELLER {
        override fun getMessage(): String {
            return "O vendedor %s foi destaque em %s com um total de R$%s"
        }
    };

    abstract fun getMessage(): String
}