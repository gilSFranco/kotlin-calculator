package com.fatec.calculator.validation.secondValue.model

sealed class SecondValueFormEvent {
    data class SecondValueChanged(val secondValue: Int) : SecondValueFormEvent()

    object Submit : SecondValueFormEvent()
}