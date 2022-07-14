package io.github.bapadua.dsmeta.repository

import io.github.bapadua.dsmeta.entity.Sale
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDate
import java.util.UUID

interface SalesRepository : JpaRepository<Sale, UUID> {

    @Query("SELECT s FROM Sale s WHERE s.date BETWEEN :min AND :max ORDER BY s.amount DESC")
    fun findSales(min: LocalDate, max: LocalDate, pageable: Pageable): Page<Sale>
}