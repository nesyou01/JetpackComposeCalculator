package com.nesyou.calculator.models

import com.nesyou.calculator.R

sealed class CalculatorButton(
    val char: Any,
    val type: ButtonType,
    val hidden: Boolean = false
) {

    object Number0 : CalculatorButton("0", ButtonType.Number(0))
    object Comma : CalculatorButton(".", ButtonType.Number('.'))
    object Number1 : CalculatorButton("1", ButtonType.Number(1))
    object Number2 : CalculatorButton("2", ButtonType.Number(2))
    object Number3 : CalculatorButton("3", ButtonType.Number(3))
    object Number4 : CalculatorButton("4", ButtonType.Number(4))
    object Number5 : CalculatorButton("5", ButtonType.Number(5))
    object Number6 : CalculatorButton("6", ButtonType.Number(6))
    object Number7 : CalculatorButton("7", ButtonType.Number(7))
    object Number8 : CalculatorButton("8", ButtonType.Number(8))
    object Number9 : CalculatorButton("9", ButtonType.Number(9))
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
        "–",
        ButtonType.MathematicalCalculation(MathematicalCalculationButton.Minus)
    )

    object Plus : CalculatorButton(
        "+",
        ButtonType.MathematicalCalculation(MathematicalCalculationButton.Plus)
    )


    companion object {
        private val FirstColumn = listOf(
            Clear,
            Number7,
            Number4,
            Number1,
            Expand
        )
        private val SecondColumn = listOf(
            Remove,
            Number8,
            Number5,
            Number2,
            Number0
        )
        private val ThirdColumn = listOf(
            Power,
            Number9,
            Number6,
            Number3,
            Comma
        )
        private val FourthColumn = listOf(
            Divide,
            Times,
            Minus,
            Plus,
            Calculate
        )


        val Values = listOf(
            FirstColumn,
            SecondColumn,
            ThirdColumn,
            FourthColumn
        )

    }

}
