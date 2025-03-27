package com.fatec.calculator.validation.secondValue.model

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatec.calculator.validation.FormState
import com.fatec.calculator.validation.use_case.ValidationNumber
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SecondValueViewModel (
    private val validateNumber: ValidationNumber = ValidationNumber()
) : ViewModel() {
    var state by mutableStateOf(FormState())

    private val validationEventChannel = Channel<ValidationNumberField>()
    val validationEvent = validationEventChannel.receiveAsFlow()

    fun onEvent (event: SecondValueFormEvent) {
        when (event) {
            is SecondValueFormEvent.SecondValueChanged -> {
                state = state.copy(
                    secondValue = event.secondValue
                )
            }

            is SecondValueFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val secondValueResult = validateNumber.execute(state.secondValue)

        if (!secondValueResult.successful) {
            state = state.copy(
                secondValueError = secondValueResult.errorMessage
            )
            return
        }

        state = state.copy(
            secondValueError = null
        )

        viewModelScope.launch {
            validationEventChannel.send(ValidationNumberField.Success)
        }
    }

    sealed class ValidationNumberField {
        object Success : ValidationNumberField()
    }
}