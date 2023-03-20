package com.mercadolivro.controller.response

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.CustomerModel
import java.math.BigDecimal
import javax.persistence.*

class BookResponse(

        var id: Int? = null,

        var name: String? = null,

        var price: BigDecimal? = null,

        var customer: CustomerModel? = null,

        var status: BookStatus? = null

)
