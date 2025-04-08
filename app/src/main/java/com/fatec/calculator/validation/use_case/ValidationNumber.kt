package com.fatec.calculator.validation.use_case

import com.fatec.calculator.validation.ValidationResult

class ValidationNumber {

    private val decimalRegex = Regex("^-?\\d+(?:[.,]\\d+)?$")

    fun execute (number: String) : ValidationResult {
        if (number.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Digite um número"
            )
        }

        if (!decimalRegex.matches(number)) {
            return ValidationResult(
                successful = false,
                errorMessage = "Digite um número válido"
            )
        }

        return ValidationResult(
            successful = true
        )
    }

}