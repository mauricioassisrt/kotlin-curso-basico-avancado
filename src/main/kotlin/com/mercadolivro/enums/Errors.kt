package com.mercadolivro.enums

enum class Errors(val code: String, val message: String) {
    ML000("ML-000", "Acess denied"),
    ML001("ML-001" , "Invalid Request"),
    ML101("ML-101", "Customer %s not exist"),
    ML102("ML-102", "Cannot update book with status [%s]"),
    ML201("ML-201", "Book %s not exist")
}
