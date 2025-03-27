package com.fatec.calculator.validation

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)