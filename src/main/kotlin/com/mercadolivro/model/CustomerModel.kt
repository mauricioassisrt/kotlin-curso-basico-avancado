package com.mercadolivro.model

import com.mercadolivro.enums.CustomerStatus
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "customer")
class CustomerModel(
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @Column(name = "name")
        var name: String? = null,
        @Column(name = "email")
        var email: String? = null,

        @Column
        @Enumerated(EnumType.STRING)
        var status: CustomerStatus

        ) : Serializable
