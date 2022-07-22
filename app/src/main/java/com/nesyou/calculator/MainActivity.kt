package com.nesyou.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.nesyou.calculator.ui.CalculatorScreen
import com.nesyou.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                ) {
                    CalculatorScreen()
                }
            }
        }
    }
}
