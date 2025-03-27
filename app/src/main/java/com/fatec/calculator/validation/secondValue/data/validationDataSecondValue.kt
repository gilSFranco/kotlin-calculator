package com.fatec.calculator.validation.secondValue.data

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.fatec.calculator.validation.FormState
import com.fatec.calculator.validation.secondValue.model.SecondValueViewModel

@Composable
fun validationDataSecondValue (
    context: Context,
    viewModelSecondValue: SecondValueViewModel,
    stateSecondValue: FormState
) : Boolean {
    var success by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = context) {
        viewModelSecondValue.validationEvent.collect { event ->
            when (event) {
                is SecondValueViewModel.ValidationNumberField.Success -> {
                    success = true
                }
            }
        }
    }

    if (stateSecondValue.secondValueError != null) {
        success = false
    }

    return success
}