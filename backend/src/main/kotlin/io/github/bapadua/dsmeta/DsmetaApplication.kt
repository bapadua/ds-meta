package io.github.bapadua.dsmeta

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DsmetaApplication

fun main(args: Array<String>) {
	runApplication<DsmetaApplication>(*args)
}
