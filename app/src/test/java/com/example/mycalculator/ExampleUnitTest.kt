package com.example.mycalculator

import org.junit.Assert.assertEquals
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals("4", CalculatorEngine.evaluate("2+2"))
    }

    @Test
    fun subtraction_isCorrect() {
        assertEquals("6", CalculatorEngine.evaluate("10-4"))
    }

    @Test
    fun multiplication_isCorrect() {
        assertEquals("42", CalculatorEngine.evaluate("6*7"))
    }

    @Test
    fun division_isCorrect() {
        assertEquals("5", CalculatorEngine.evaluate("20/4"))
    }

    @Test
    fun operatorPrecedence_isCorrect() {
        assertEquals("14", CalculatorEngine.evaluate("2+3*4"))
    }

    @Test
    fun parentheses_isCorrect() {
        assertEquals("20", CalculatorEngine.evaluate("(2+3)*4"))
    }

    @Test
    fun power_isCorrect() {
        assertEquals("8", CalculatorEngine.evaluate("2^3"))
    }

    @Test
    fun sin_isCorrect() {
        assertEquals("1", CalculatorEngine.evaluate("sin(90)"))
    }

    @Test
    fun cos_isCorrect() {
        assertEquals("1", CalculatorEngine.evaluate("cos(0)"))
    }

    @Test
    fun tan_isCorrect() {
        assertEquals("1", CalculatorEngine.evaluate("tan(45)"))
    }

    @Test
    fun sqrt_isCorrect() {
        assertEquals("4", CalculatorEngine.evaluate("sqrt(16)"))
    }

    @Test
    fun log_isCorrect() {
        assertEquals("2", CalculatorEngine.evaluate("log10(100)"))
    }

    @Test
    fun ln_isCorrect() {
        assertEquals("0", CalculatorEngine.evaluate("ln(1)"))
    }

    @Test
    fun pi_isCorrect() {
        assertEquals("3.14159265", CalculatorEngine.evaluate("pi"))
    }

    @Test
    fun divisionByZero_isError() {
        assertEquals("Error", CalculatorEngine.evaluate("10/0"))
    }

    @Test
    fun invalidExpression_isError() {
        assertEquals("Error", CalculatorEngine.evaluate("2+*3"))
    }

    @Test
    fun negativeSqrt_isError() {
        assertEquals("Error", CalculatorEngine.evaluate("sqrt(-4)"))
    }

    @Test
    fun emptyExpression_returnsZero() {
        assertEquals("0", CalculatorEngine.evaluate(""))
    }
}