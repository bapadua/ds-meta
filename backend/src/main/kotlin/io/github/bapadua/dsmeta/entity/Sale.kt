package io.github.bapadua.dsmeta.entity

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_sales")
class Sale(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    val id: UUID? = null,

    @Column(name = "seller_name")
    val sellerName: String,
    
    @Column(name = "visited")
    val visited: Long,
    
    @Column(name = "deals")
    val deals: Long,

    @Column(name = "amount")
    val amount: BigDecimal,

    @Column(name = "date")
    val date: LocalDate

)
