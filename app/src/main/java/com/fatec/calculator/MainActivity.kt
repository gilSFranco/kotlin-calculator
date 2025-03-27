package com.fatec.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.fatec.calculator.ui.presentation.Screen
import com.fatec.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme = remember {
                mutableStateOf(false)
            }

            CalculatorTheme(
                darkTheme = isDarkTheme.value
            ) {
                Screen(
                    isDarkTheme = isDarkTheme,
                    onChecked = { isChecked ->
                        isDarkTheme.value = isChecked
                    }
                )
            }
        }
    }
}