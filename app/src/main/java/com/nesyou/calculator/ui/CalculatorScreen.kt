package com.nesyou.calculator.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nesyou.calculator.R
import com.nesyou.calculator.models.CalculatorButton
import com.nesyou.calculator.ui.components.CalculatorButton
import com.nesyou.calculator.ui.components.Input

@Composable
fun CalculatorScreen(vm: CalculatorViewModel = viewModel()) {
    val state by vm.state.collectAsState()
    Column(
        modifier = Modifier
            .padding(horizontal = dimensionResource(R.dimen.normal))
    ) {
        Column(
            Modifier
                .weight(1F),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Input(state.textFiledValue) {
                vm.onValueChanged(it)
            }
            Text(
                state.result.let { if (it.isNotEmpty()) "=$it" else "" },
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.small))
        )
        BoxWithConstraints(
            Modifier
                .fillMaxWidth()
                .weight(1.5F)
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
                                        .weight(1F), it
                                ) {
                                    vm(it)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}