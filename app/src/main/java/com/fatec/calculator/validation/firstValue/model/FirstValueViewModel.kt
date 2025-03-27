package com.fatec.calculator.validation.firstValue.model

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatec.calculator.validation.FormState
import com.fatec.calculator.validation.use_case.ValidationNumber
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class FirstValueViewModel (
    private val validateNumber: ValidationNumber = ValidationNumber()
) : ViewModel() {
    var state by mutableStateOf(FormState())

    private val validationEventChannel = Channel<ValidationNumberField>()
    val validationEvent = validationEventChannel.receiveAsFlow()

    fun onEvent (event: FirstValueFormEvent) {
        when (event) {
            is FirstValueFormEvent.FirstValueChanged -> {
                state = state.copy(
                    firstValue = event.firstValue
                )
            }

            is FirstValueFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val firstValueResult = validateNumber.execute(state.firstValue)

        if (!firstValueResult.successful) {
            state = state.copy(
                firstValueError = firstValueResult.errorMessage
            )
            return
        }

        state = state.copy(
            firstValueError = null
        )

        viewModelScope.launch {
            validationEventChannel.send(ValidationNumberField.Success)
        }
    }

    sealed class ValidationNumberField {
        object Success : ValidationNumberField()
    }
}