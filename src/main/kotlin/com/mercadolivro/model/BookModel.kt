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

        @ManyToOne
        @JoinColumn(name = "customer_id")
        var customer: CustomerModel? = null

) {
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) {
            if (field == BookStatus.DELETADO || field == BookStatus.CANCELADO) {
                throw Exception("Não é possivel alterar um livro com status ${field}")
            }
            field = value
        }

    constructor(id: Int? = null,
                name: String? = null,
                price: BigDecimal? = null,
                customer: CustomerModel? = null,
                status: BookStatus?) : this(id, name, price, customer) {
        this.status = status
    }
}
