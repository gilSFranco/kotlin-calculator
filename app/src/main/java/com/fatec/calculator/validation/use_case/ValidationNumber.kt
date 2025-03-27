package com.fatec.calculator.validation.use_case

import com.fatec.calculator.validation.ValidationResult

class ValidationNumber {

    fun execute (number: Int) : ValidationResult {
        if (number.toString().isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Digite o primeiro valor"
            )
        }

        return ValidationResult(
            successful = true
        )
    }

}