package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.extension.toBookModel
import com.mercadolivro.model.BookModel
import com.mercadolivro.service.BookService
import com.mercadolivro.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.awt.print.Book

@RestController
@RequestMapping("book")
class BookController {

    @Autowired
    private lateinit var customerService: CustomerService
    @Autowired
    private lateinit var bookService: BookService
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody requestBody: PostBookRequest){
      val customer =  customerService.getById(requestBody.customerId)
        bookService.create(requestBody.toBookModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookModel> = bookService.findAll()

    @GetMapping("/active")
    fun findActives(): List<BookModel> = bookService.findActives()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookModel = bookService.findById(id)

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) = bookService.delete(id)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
       val bookSaved = bookService.findById(id)
        bookService.update(book.toBookModel(bookSaved))
    }
}
