package com.fatec.calculator.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.fatec.calculator.R
import com.fatec.calculator.ui.theme.BRANCO
import com.fatec.calculator.ui.theme.PRETO

@Composable
fun SwitchTheme (
    isDarkTheme: Boolean,
    onChecked: (Boolean) -> Unit
) {
    Switch(
        checked = isDarkTheme,
        onCheckedChange = onChecked,
        thumbContent = {
            Icon(
                imageVector =
                if (isDarkTheme) {
                    ImageVector.vectorResource(id = R.drawable.baseline_mode_night_24)
                } else {
                    ImageVector.vectorResource(id = R.drawable.baseline_sunny_24)
                },
                contentDescription = null,
                modifier = Modifier
                    .scale(0.6f)
            )
        },
        colors = SwitchDefaults.colors(
            checkedBorderColor = BRANCO,
            uncheckedBorderColor = PRETO,
            checkedIconColor = PRETO,
            uncheckedIconColor = BRANCO,
            checkedThumbColor = BRANCO,
            uncheckedThumbColor = PRETO,
            checkedTrackColor = PRETO,
            uncheckedTrackColor = BRANCO
        ),
        modifier = Modifier
            .padding(end = 10.dp)
    )
}