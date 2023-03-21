package com.mercadolivro.events

import com.mercadolivro.model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent(
        source:Any,
        val purcheaseModel:  PurchaseModel
) :ApplicationEvent(source)
