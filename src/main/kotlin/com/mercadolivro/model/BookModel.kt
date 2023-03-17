package com.mercadolivro.model

import com.mercadolivro.enums.BookStatus
import java.io.Serializable
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "book")
class BookModel(
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @Column(name = "name")
        var name: String? = null,

        @Column(name = "price")
        var price: BigDecimal? = null,

        @Column
        @Enumerated(EnumType.STRING)
        var status: BookStatus?,
        @ManyToOne
        @JoinColumn(name= "customer_id")
        var customer: CustomerModel? = null

        ) : Serializable
