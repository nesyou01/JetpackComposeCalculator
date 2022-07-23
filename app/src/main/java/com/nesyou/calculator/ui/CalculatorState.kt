package com.nesyou.calculator.ui

import androidx.compose.ui.text.input.TextFieldValue

data class CalculatorState(
    val textFiledValue: TextFieldValue = TextFieldValue(),
    val result: String = "",
)
