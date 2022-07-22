package com.nesyou.calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.nesyou.calculator.R
import com.nesyou.calculator.models.CalculatorButton
import com.nesyou.calculator.ui.components.CalculatorButton

@Composable
fun CalculatorScreen() {
    Column(
        modifier = Modifier
            .padding(horizontal = dimensionResource(R.dimen.normal))
    ) {
        Box(
            Modifier
                .background(Color.Red)
                .weight(1F)
        )
        Divider(color = MaterialTheme.colorScheme.outline)
        BoxWithConstraints(
            Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.small))
        ) {
            val smallSize = dimensionResource(R.dimen.small)
            val maxWidth = remember(this.maxWidth, smallSize) { maxWidth - (smallSize * 3) }
            Row(
                horizontalArrangement = Arrangement.spacedBy(smallSize)
            ) {
                CalculatorButton.Values.forEachIndexed { i, buttonList ->
                    Surface(
                        color = if (i == CalculatorButton.Values.size - 1) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.background,
                        shape = MaterialTheme.shapes.extraLarge,
                    ) {
                        Column {
                            buttonList.forEach {
                                CalculatorButton(
                                    Modifier
                                        .width(maxWidth / 4)
                                        .aspectRatio(1F), it
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}