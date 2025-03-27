package com.fatec.calculator.validation

data class FormState (
    val firstValue: Int = 0,
    val firstValueError: String? = null,
    val secondValue: Int = 0,
    val secondValueError: String? = null
)