package com.mercadolivro.repository

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface BookRepository: JpaRepository<BookModel, Int> {
    abstract fun findByStatus(ativo: BookStatus, pageable: Pageable): Page<BookModel>
    fun findByCustomer(customerModel: CustomerModel): List<BookModel>

   // fun findAll(pageable: Pageable): Page<BookModel>
}
