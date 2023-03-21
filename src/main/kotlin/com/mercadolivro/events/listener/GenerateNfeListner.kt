package com.mercadolivro.events.listener

import com.mercadolivro.events.PurchaseEvent
import com.mercadolivro.service.PurchaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

@Component
class GenerateNfeListner {

    @Autowired
    private lateinit var purchaseService: PurchaseService
    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent){
        println("Gerando NFE")
        val nfe = UUID.randomUUID().toString()
        val purchaseModel = purchaseEvent.purcheaseModel.copy(nfe = nfe)
        purchaseService.update(purchaseModel)
    }
}
