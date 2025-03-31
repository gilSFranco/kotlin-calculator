package com.fatec.calculator.validation.use_case

import com.fatec.calculator.validation.ValidationResult

class ValidationNumber {

    fun execute (number: String) : ValidationResult {
        if (number.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Digite um número"
            )
        }

        val containsInvalidChar = number.any { !it.isDigit() }

        if (containsInvalidChar) {
            return ValidationResult(
                successful = false,
                errorMessage = "Somente números são aceitos"
            )
        }

        return ValidationResult(
            successful = true
        )
    }

}