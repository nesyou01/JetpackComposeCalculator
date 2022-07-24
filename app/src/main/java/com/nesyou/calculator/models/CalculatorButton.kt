package com.nesyou.calculator.models

import com.nesyou.calculator.R

sealed class CalculatorButton(
    val symbol: Any,
    val type: ButtonType,
) {

    object Number0 : CalculatorButton("0", ButtonType.Number)
    object Comma : CalculatorButton(".", ButtonType.Number)
    object Number1 : CalculatorButton("1", ButtonType.Number)
    object Number2 : CalculatorButton("2", ButtonType.Number)
    object Number3 : CalculatorButton("3", ButtonType.Number)
    object Number4 : CalculatorButton("4", ButtonType.Number)
    object Number5 : CalculatorButton("5", ButtonType.Number)
    object Number6 : CalculatorButton("6", ButtonType.Number)
    object Number7 : CalculatorButton("7", ButtonType.Number)
    object Number8 : CalculatorButton("8", ButtonType.Number)
    object Number9 : CalculatorButton("9", ButtonType.Number)
    object Clear : CalculatorButton("C", ButtonType.Action(Action.Clear))
    object Remove : CalculatorButton(R.drawable.ic_remove, ButtonType.Action(Action.Remove))
    object Expand : CalculatorButton(R.drawable.ic_expand, ButtonType.Action(Action.Expand))
    object Calculate : CalculatorButton("=", ButtonType.Action(Action.Calculate))

    object Power : CalculatorButton(
        "^",
        ButtonType.MathematicalCalculation(MathematicalCalculationButton.Power)
    )

    object Divide : CalculatorButton(
        "÷",
        ButtonType.MathematicalCalculation(MathematicalCalculationButton.Divide)
    )

    object Times : CalculatorButton(
        "×",
        ButtonType.MathematicalCalculation(MathematicalCalculationButton.Times)
    )

    object Minus : CalculatorButton(
        "-",
        ButtonType.MathematicalCalculation(MathematicalCalculationButton.Minus)
    )

    object Plus : CalculatorButton(
        "+",
        ButtonType.MathematicalCalculation(MathematicalCalculationButton.Plus)
    )


    companion object {
        val values = listOf(
            // First Column
            listOf(
                Clear,
                Number7,
                Number4,
                Number1,
                Expand
            ),
            // Second Column
            listOf(
                Remove,
                Number8,
                Number5,
                Number2,
                Number0
            ),
            // Third Column
            listOf(
                Power,
                Number9,
                Number6,
                Number3,
                Comma
            ),
            // Fourth Column
            listOf(
                Divide,
                Times,
                Minus,
                Plus,
                Calculate
            )
        )

    }
}
