package com.nesyou.calculator.models

sealed class ButtonType {


    class Number(val value: Any) : ButtonType()
    class MathematicalCalculation(val value: MathematicalCalculationButton) : ButtonType()
    class Action(val action: com.nesyou.calculator.models.Action) : ButtonType()

}