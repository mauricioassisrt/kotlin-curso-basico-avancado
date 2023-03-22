package com.mercadolivro.extension

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.controller.response.BookResponse
import com.mercadolivro.controller.response.CustomerResponse
import com.mercadolivro.controller.response.PageResponse
import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import org.springframework.data.domain.Page

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(
            name = this.name,
            email = this.email,
            status = CustomerStatus.ATIVO,
            password = this.password
    )
}

fun PutCustomerRequest.toCustomerModel(customerSaved: CustomerModel): CustomerModel {
    return CustomerModel(
            id = customerSaved.id,
            name = this.name,
            email = this.email,
            status = customerSaved.status,
            password = this.password
    )
}

fun PostBookRequest.toBookModel(customerModel: CustomerModel): BookModel {
    return BookModel(
            name = this.name,
            price = this.price,
            status = BookStatus.ATIVO,
            customer = customerModel
    )
}

fun PutBookRequest.toBookModel(bookModel: BookModel): BookModel {
    return BookModel(
            id = bookModel.id,
            name = this.name ?: bookModel.name,
            price = this.price ?: bookModel.price,
            status = bookModel.status,
            customer = bookModel.customer
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
            id = this.id,
            name = this.name,
            email = this.email,
            status = this.status
    )
}

fun BookModel.toResponse(): BookResponse {
    return BookResponse(
            id = this.id,
            name = this.name,
            price = this.price,
            customer = this.customer,
            status = this.status
    )
}

fun <T> Page<T>.toPageResponse(): PageResponse<T> {
    return PageResponse(
            this.content,
            this.number,
            this.totalElements,
            this.totalPages
    )
}
