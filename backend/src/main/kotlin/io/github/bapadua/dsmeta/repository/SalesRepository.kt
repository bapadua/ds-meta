package io.github.bapadua.dsmeta.repository

import io.github.bapadua.dsmeta.entity.Sale
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SalesRepository : JpaRepository<Sale, UUID> {

}