package com.mercadolivro.controller.response

import com.mercadolivro.enums.CustomerStatus
import javax.persistence.*

data class CustomerResponse(
        var id: Int? = null,

        var name: String? = null,

        var email: String? = null,

        var status: CustomerStatus
)
