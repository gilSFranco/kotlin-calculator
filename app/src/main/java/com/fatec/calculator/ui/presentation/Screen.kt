package com.fatec.calculator.ui.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.fatec.calculator.ui.components.Calculator
import com.fatec.calculator.ui.components.SwitchTheme
import com.fatec.calculator.ui.components.TitleTopAppBar
import com.fatec.calculator.ui.theme.BRANCO_MENOS_CLARO
import com.fatec.calculator.ui.theme.PRETO_MAIS_CLARO

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen (
    isDarkTheme: MutableState<Boolean>,
    onChecked: (Boolean) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TitleTopAppBar(
                        isDarkTheme = isDarkTheme.value
                    )
                },
                actions = {
                    SwitchTheme(
                        isDarkTheme = isDarkTheme.value,
                        onChecked = onChecked
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (isDarkTheme.value) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO
                )
            )
        },
        modifier = Modifier.fillMaxSize(),
        containerColor = if (isDarkTheme.value) PRETO_MAIS_CLARO else BRANCO_MENOS_CLARO
    ) { innerPadding ->
        Calculator(
            paddingTop = innerPadding.calculateTopPadding(),
            isDarkTheme = isDarkTheme.value
        )
    }
}