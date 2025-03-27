package com.fatec.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.fatec.calculator.ui.components.Calculator
import com.fatec.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isDarkTheme = remember { mutableStateOf(true) }

            CalculatorTheme(
                darkTheme = isDarkTheme.value
            ) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Calculator(
                        paddingTop = innerPadding.calculateTopPadding()
                    )
                }
            }
        }
    }
}