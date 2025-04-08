package com.fatec.calculator.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fatec.calculator.validation.firstValue.data.validationDataFirstValue
import com.fatec.calculator.validation.firstValue.model.FirstValueFormEvent
import com.fatec.calculator.validation.firstValue.model.FirstValueViewModel
import com.fatec.calculator.validation.secondValue.data.validationDataSecondValue
import com.fatec.calculator.validation.secondValue.model.SecondValueFormEvent
import com.fatec.calculator.validation.secondValue.model.SecondValueViewModel

@Composable
fun Calculator (
    paddingTop: Dp,
    isDarkTheme: Boolean
) {
    val context = LocalContext.current

    val viewModelFirstValue = viewModel<FirstValueViewModel>()
    val stateFirstValue = viewModelFirstValue.state

    val viewModelSecondValue = viewModel<SecondValueViewModel>()
    val stateSecondValue = viewModelSecondValue.state

    var sum by remember {
        mutableStateOf(false)
    }

    var subtraction by remember {
        mutableStateOf(false)
    }

    var multiplication by remember {
        mutableStateOf(false)
    }

    var division by remember {
        mutableStateOf(false)
    }

    var result by remember {
        mutableFloatStateOf(0f)
    }

    val validationDataFirstValue = validationDataFirstValue(
        context = context,
        viewModelFirstValue = viewModelFirstValue,
        stateFirstValue = stateFirstValue
    )

    val validationDataSecondValue = validationDataSecondValue(
        context = context,
        viewModelSecondValue = viewModelSecondValue,
        stateSecondValue = stateSecondValue
    )

    val isValidationSuccessful = validationDataFirstValue && validationDataSecondValue

    Column (
        modifier = Modifier
            .padding(top = paddingTop, start = 30.dp, end = 30.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CalculatorTextField(
            value = stateFirstValue.firstValue,
            onValueChange = {
                viewModelFirstValue.onEvent(FirstValueFormEvent.FirstValueChanged(it))
                viewModelFirstValue.onEvent(FirstValueFormEvent.Submit)
            },
            isError = stateFirstValue.firstValueError != null,
            errorState = stateFirstValue.firstValueError,
            label = "Valor 1",
            placeholder = "Digite um valor",
            keyboardType = KeyboardType.Number,
            isDarkTheme = isDarkTheme
        )

        CalculatorTextField(
            value = stateSecondValue.secondValue,
            onValueChange = {
                viewModelSecondValue.onEvent(SecondValueFormEvent.SecondValueChanged(it))
                viewModelSecondValue.onEvent(SecondValueFormEvent.Submit)
            },
            isError = stateSecondValue.secondValueError != null,
            errorState = stateSecondValue.secondValueError,
            label = "Valor 2",
            placeholder = "Digite um valor",
            keyboardType = KeyboardType.Number,
            lastOne = true,
            isDarkTheme = isDarkTheme
        )

        Row (
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                space =  10.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            CalculateButton(
                modifier = Modifier
                    .padding(bottom = if (sum) 5.dp else 0.dp)
                    .width(50.dp),
                isDarkTheme = isDarkTheme,
                onClick = {
                    sum = true
                    subtraction = false
                    multiplication = false
                    division = false
                },
                buttonText = "+",
                isActive = sum
            )

            CalculateButton(
                modifier = Modifier
                    .padding(bottom = if (subtraction) 5.dp else 0.dp)
                    .width(50.dp),
                isDarkTheme = isDarkTheme,
                onClick = {
                    sum = false
                    subtraction = true
                    multiplication = false
                    division = false
                },
                buttonText = "-",
                isActive = subtraction
            )

            CalculateButton(
                modifier = Modifier
                    .padding(bottom = if (multiplication) 5.dp else 0.dp)
                    .width(50.dp),
                isDarkTheme = isDarkTheme,
                onClick = {
                    sum = false
                    subtraction = false
                    multiplication = true
                    division = false
                },
                buttonText = "x",
                isActive = multiplication
            )

            CalculateButton(
                modifier = Modifier
                    .padding(bottom = if (division) 5.dp else 0.dp)
                    .width(50.dp),
                isDarkTheme = isDarkTheme,
                onClick = {
                    sum = false
                    subtraction = false
                    multiplication = false
                    division = true
                },
                buttonText = "/",
                isActive = division
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        ResultTextField(
            value = if (stateFirstValue.firstValue.isNotBlank() && stateSecondValue.secondValue.isNotBlank()) result.toString() else "Esperando pelos valores...",
            onValueChange = {},
            isError = stateSecondValue.secondValueError != null || stateFirstValue.firstValueError != null,
            errorState = if (stateSecondValue.secondValueError != null || stateFirstValue.firstValueError != null) "Digite os números para fazer uma operação..." else "",
            isDarkTheme = isDarkTheme
        )

        Spacer(modifier = Modifier.height(20.dp))

        CalculateButton(
            modifier = Modifier
                .fillMaxWidth(),
            isDarkTheme = isDarkTheme,
            onClick = {
                viewModelFirstValue.onEvent(FirstValueFormEvent.Submit)
                viewModelSecondValue.onEvent(SecondValueFormEvent.Submit)

                val firstValue = stateFirstValue.firstValue.replace(',', '.')
                val secondValue = stateSecondValue.secondValue.replace(',', '.')

                when {
                    isValidationSuccessful && sum -> {
                        result = firstValue.toFloat() + secondValue.toFloat()
                    }

                    isValidationSuccessful && subtraction -> {
                        result = firstValue.toFloat() - secondValue.toFloat()
                    }

                    isValidationSuccessful && multiplication -> {
                        result = firstValue.toFloat() * secondValue.toFloat()
                    }

                    isValidationSuccessful && division -> {
                        result = firstValue.toFloat() / secondValue.toFloat()
                    }
                }
            },
            buttonText = "Calcular",
            verticalPadding = 15.dp
        )
    }
}