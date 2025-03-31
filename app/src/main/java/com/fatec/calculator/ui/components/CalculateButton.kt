package com.fatec.calculator.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fatec.calculator.ui.theme.BRANCO_MENOS_CLARO
import com.fatec.calculator.ui.theme.PRETO_MAIS_CLARO
import com.fatec.calculator.ui.theme.Typography
import com.fatec.calculator.ui.theme.VERDE

@Composable
fun CalculateButton(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    onClick: () -> Unit,
    buttonText: String,
    verticalPadding: Dp = 10.dp,
    isActive: Boolean = false
) {
    Card (
        onClick = onClick,
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = if (!isDarkTheme) if (isActive) VERDE else PRETO_MAIS_CLARO else if (isActive) VERDE else BRANCO_MENOS_CLARO,
            contentColor = if (isDarkTheme) if (isActive) BRANCO_MENOS_CLARO else PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO
        )
    ) {
        Text(
            text = buttonText,
            style = Typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = verticalPadding)
                .fillMaxWidth()
        )
    }
}