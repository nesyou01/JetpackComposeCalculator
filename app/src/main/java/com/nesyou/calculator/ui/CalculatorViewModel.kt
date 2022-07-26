package com.nesyou.calculator.ui

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nesyou.calculator.models.ButtonType
import com.nesyou.calculator.models.CalculatorButton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorViewModel : ViewModel() {

    private var _state = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state.asStateFlow()

    private val listOfButtons = CalculatorButton.values.flatten()

    operator fun invoke(button: CalculatorButton) {
        viewModelScope.launch {
            if (button.type is ButtonType.Action) {
                onActionClicked(button)
            } else {
                changeTextValue(
                    _state.value.textFiledValue.text.let {
                        if (it.contains("Error", true)) {
                            button.symbol.toString()
                        } else {
                            it.plus(button.symbol)
                        }
                    },
                )
            }
        }
    }

    private fun onActionClicked(button: CalculatorButton) {
        when (button) {
            CalculatorButton.Clear -> clear()
            CalculatorButton.Remove -> remove()
            CalculatorButton.Expand -> {
                _state.value = _state.value.copy(
                    expanded = !_state.value.expanded
                )
            }
            CalculatorButton.Calculate -> calculate()
            else -> {
                throw Exception("This action is not supported")
            }
        }
    }

    private fun remove() {
        _state.value.textFiledValue.text.let {
            if (it.isNotEmpty()) changeTextValue(it.dropLast(1))
        }
    }

    private fun clear() {
        _state.value = CalculatorState()
    }

    private fun calculate() {
        if (_state.value.textFiledValue.text.isNotEmpty()) {
            try {
                changeTextValue(calculateText(_state.value.textFiledValue.text))
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
            }
        }
    }

    private fun calculateText(text: String): String {
        return try {
            return ExpressionBuilder(formattedString(text)).build()
                .evaluate().toString()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            "Error"
        } catch (e: ArithmeticException) {
            "Error:${e.message}"
        }
    }

    fun onValueChanged(textFieldValue: TextFieldValue) {
        _state.value = _state.value.copy(textFiledValue = textFieldValue)
    }

    private fun formattedString(text: String): String {
        var y = text
        listOfButtons.filter { it.type is ButtonType.MathematicalCalculation }.forEach {
            y = y.replace(
                it.symbol.toString(),
                " ${(it.type as ButtonType.MathematicalCalculation).value.char} ",
            )
        }
        return y
    }

    private fun changeTextValue(text: String) {
        _state.value = _state.value.copy(
            textFiledValue = TextFieldValue(
                text = text,
                selection = TextRange(text.length)
            ),
            result = text.lastOrNull()
                ?.let {
                    if (it.isDigit() && !text.replace(".", "")
                            .isDigitsOnly()
                    ) calculateText(text) else ""
                }
                ?: ""
        )

    }
}