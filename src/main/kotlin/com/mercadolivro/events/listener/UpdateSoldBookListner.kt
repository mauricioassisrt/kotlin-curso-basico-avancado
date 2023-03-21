package com.mercadolivro.events.listener

import com.mercadolivro.events.PurchaseEvent
import com.mercadolivro.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class UpdateSoldBookListner {

    @Autowired
    private lateinit var bookService: BookService
    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent){
        println("Atualizando livro")
        bookService.purchase(purchaseEvent.purcheaseModel.books)
    }
}
