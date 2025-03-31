package com.fatec.calculator.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.fatec.calculator.R
import com.fatec.calculator.ui.theme.BRANCO_MENOS_CLARO
import com.fatec.calculator.ui.theme.PRETO_MAIS_CLARO
import com.fatec.calculator.ui.theme.Typography
import com.fatec.calculator.ui.theme.VERMELHO

@Composable
fun ResultTextField (
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean,
    errorState: String?,
    isDarkTheme: Boolean
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        isError = isError,
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = if (!isDarkTheme) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO,
            focusedTextColor = if (!isDarkTheme) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO,

            unfocusedBorderColor = if (!isDarkTheme) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO,
            focusedBorderColor = if (!isDarkTheme) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO,

            unfocusedContainerColor = if (!isDarkTheme) BRANCO_MENOS_CLARO else PRETO_MAIS_CLARO,
            focusedContainerColor = if (!isDarkTheme) BRANCO_MENOS_CLARO else PRETO_MAIS_CLARO,

            unfocusedLabelColor = if (!isDarkTheme) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO,
            focusedLabelColor = if (!isDarkTheme) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO,

            unfocusedPlaceholderColor = if (!isDarkTheme) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO,
            focusedPlaceholderColor = if (!isDarkTheme) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO,

            unfocusedLeadingIconColor = if (!isDarkTheme) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO,
            focusedLeadingIconColor = if (!isDarkTheme) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO,

            cursorColor = if (!isDarkTheme) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO,

            focusedSupportingTextColor = if (!isDarkTheme) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO,
            unfocusedSupportingTextColor = if (!isDarkTheme) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO,

            errorSupportingTextColor = VERMELHO,
            errorTextColor = VERMELHO,
            errorPlaceholderColor = VERMELHO,
            errorLeadingIconColor = VERMELHO
        ),
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_pause_24),
                contentDescription = "Icone de Caneta",
                modifier = Modifier
                    .rotate(90f)
                    .scale(0.8f)
            )
        },
        supportingText = {
            Text(
                text = errorState ?: "",
                style = Typography.labelSmall
            )
        },
        readOnly = true
    )
}