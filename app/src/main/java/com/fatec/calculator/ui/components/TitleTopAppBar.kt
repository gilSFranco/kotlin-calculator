package com.fatec.calculator.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.fatec.calculator.R
import com.fatec.calculator.ui.theme.Typography

@Composable
fun TitleTopAppBar () {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_calculate_24),
            contentDescription = "Icone de calculadora",
            modifier = Modifier
                .scale(1.2f)
        )

        Text(
            text = "Calculadora",
            style = Typography.titleLarge
        )
    }
}