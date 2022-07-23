package com.nesyou.calculator.models

sealed class ButtonType {


    object Number : ButtonType()
    class MathematicalCalculation(val value: MathematicalCalculationButton) : ButtonType()
    class Action(val action: com.nesyou.calculator.models.Action) : ButtonType()

}