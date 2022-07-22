package com.nesyou.calculator.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesyou.calculator.models.ButtonType
import com.nesyou.calculator.models.CalculatorButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorButton(modifier: Modifier = Modifier, button: CalculatorButton) {
    val contentColor = when (button) {
        CalculatorButton.Clear,
        CalculatorButton.Remove -> MaterialTheme.colorScheme.primary
        CalculatorButton.Calculate -> Color.White
        else -> MaterialTheme.colorScheme.onBackground
    }
    val backgroundColor = when (button) {
        is CalculatorButton.Calculate -> MaterialTheme.colorScheme.primary
        else -> Color.Transparent
    }

    Surface(
        contentColor = contentColor,
        color = backgroundColor,
        modifier = modifier,
        shape = MaterialTheme.shapes.extraLarge,
        onClick = {}
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            when (button.char) {
                is Int -> {
                    Icon(
                        painterResource(button.char),
                        contentDescription = if (button.type is ButtonType.Action) button.type.action.name else null,
                        modifier = Modifier.size(20.dp)
                    )
                }
                else -> {
                    AutoResizeText(text = button.char.toString(), fontSizeRange = FontSizeRange(15.sp,32.sp))
                }
            }
        }
    }
}