package com.fatec.calculator.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.fatec.calculator.ui.theme.BRANCO
import com.fatec.calculator.ui.theme.PRETO
import com.fatec.calculator.ui.theme.Typography
import com.fatec.calculator.ui.theme.VERMELHO

@Composable
fun CalculatorTextField (
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean,
    label: String,
    placeholder: String,
    keyboardType: KeyboardType,
    lastOne: Boolean
) {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        isError = isError,
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = PRETO,
            focusedTextColor = PRETO,

            unfocusedBorderColor = PRETO,
            focusedBorderColor = PRETO,

            unfocusedContainerColor = BRANCO,
            focusedContainerColor = BRANCO,

            unfocusedLabelColor = PRETO,
            focusedLabelColor = PRETO,

            unfocusedPlaceholderColor = PRETO,
            focusedPlaceholderColor = PRETO,

            unfocusedLeadingIconColor = PRETO,
            focusedLeadingIconColor = PRETO,

            cursorColor = PRETO,

            focusedSupportingTextColor = PRETO,
            unfocusedSupportingTextColor = PRETO,

            errorSupportingTextColor = VERMELHO
        ),
        label = {
            Text(
                text = label,
                style = Typography.bodyLarge
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                style = Typography.bodyLarge
            )
        },
        leadingIcon = {
            Icon(
                Icons.Filled.Edit,
                contentDescription = "Icone de Caneta",
                modifier = Modifier
                    .scale(1.2f)
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = if (!lastOne) ImeAction.Next else ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            },
            onDone = {
                focusManager.clearFocus()
            }
        ),
        supportingText = {
            Text(
                text = "Required text",
                style = Typography.labelSmall
            )
        }
    )
}