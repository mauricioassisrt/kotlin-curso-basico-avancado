package com.mercadolivro.service

import com.mercadolivro.model.BookModel
import com.mercadolivro.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookService {

    @Autowired
    private lateinit var bookRepository: BookRepository
    fun create(book: BookModel) {
        bookRepository.save(book)
    }

}
