package com.fatec.calculator.ui.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fatec.calculator.ui.components.Calculator
import com.fatec.calculator.ui.components.SwitchTheme
import com.fatec.calculator.ui.components.TitleTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen (
    isDarkTheme: MutableState<Boolean>,
    onChecked: (Boolean) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(end = 10.dp),
                title = {
                    TitleTopAppBar()
                },
                actions = {
                    SwitchTheme(
                        isDarkTheme = isDarkTheme.value,
                        onChecked = onChecked
                    )
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Calculator(
            paddingTop = innerPadding.calculateTopPadding()
        )
    }
}