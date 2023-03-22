package com.mercadolivro.controller.request

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.validation.EmailAvalible
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest(
        @field: NotEmpty(message = "Nome deve ser informado")
        var name: String,
        @field: Email(message = "Email deve ser informado")
        @EmailAvalible
        var email: String,

        @field: NotEmpty(message = "Senha deve ser informado")
        var password: String,
)
