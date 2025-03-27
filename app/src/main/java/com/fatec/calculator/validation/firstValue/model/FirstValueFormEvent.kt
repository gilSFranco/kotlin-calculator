package com.fatec.calculator.validation.firstValue.model

sealed class FirstValueFormEvent {
    data class FirstValueChanged(val firstValue: Int) : FirstValueFormEvent()

    object Submit : FirstValueFormEvent()
}