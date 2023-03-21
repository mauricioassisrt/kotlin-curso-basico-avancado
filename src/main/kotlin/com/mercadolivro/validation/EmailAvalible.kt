package com.mercadolivro.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue

@Constraint(validatedBy = [EmailAvalibleValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class EmailAvalible(
        val message: String = "Email já cadastrado",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = []
)
