package com.fatec.calculator.validation.firstValue.model

sealed class FirstValueFormEvent {
    data class FirstValueChanged(val firstValue: String) : FirstValueFormEvent()

    object Submit : FirstValueFormEvent()
}