package com.fatec.calculator.validation.firstValue.data

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.fatec.calculator.validation.FormState
import com.fatec.calculator.validation.firstValue.model.FirstValueViewModel

@Composable
fun validationDataFirstValue (
    context: Context,
    viewModelFirstValue: FirstValueViewModel,
    stateFirstValue: FormState
) : Boolean {
    var success by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = context) {
        viewModelFirstValue.validationEvent.collect { event ->
            when (event) {
                is FirstValueViewModel.ValidationNumberField.Success -> {
                    success = true
                }
            }
        }
    }

    if (stateFirstValue.firstValueError != null) {
        success = false
    }

    return success
}