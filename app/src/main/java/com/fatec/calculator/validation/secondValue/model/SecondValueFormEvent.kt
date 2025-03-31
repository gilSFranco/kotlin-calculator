package com.fatec.calculator.validation.secondValue.model

sealed class SecondValueFormEvent {
    data class SecondValueChanged(val secondValue: String) : SecondValueFormEvent()

    object Submit : SecondValueFormEvent()
}