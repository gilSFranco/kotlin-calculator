package com.fatec.calculator.validation

data class FormState (
    val firstValue: String = "",
    val firstValueError: String? = null,
    val secondValue: String = "",
    val secondValueError: String? = null
)