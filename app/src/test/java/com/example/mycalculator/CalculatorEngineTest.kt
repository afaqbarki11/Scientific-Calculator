package com.example.mycalculator

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorEngineTest {

    // =========================================================
    // BASIC ARITHMETIC TESTS
    // =========================================================

    @Test
    fun testAddition() {
        assertEquals("5", CalculatorEngine.evaluate("2+3"))
        assertEquals("100", CalculatorEngine.evaluate("45+55"))
        assertEquals("12.5", CalculatorEngine.evaluate("10.2+2.3"))
    }

    @Test
    fun testSubtraction() {
        assertEquals("6", CalculatorEngine.evaluate("10-4"))
        assertEquals("-5", CalculatorEngine.evaluate("5-10"))
        assertEquals("2.5", CalculatorEngine.evaluate("5.5-3"))
    }

    @Test
    fun testMultiplication() {
        assertEquals("42", CalculatorEngine.evaluate("6*7"))
        assertEquals("0", CalculatorEngine.evaluate("100*0"))
        assertEquals("12.5", CalculatorEngine.evaluate("2.5*5"))
    }

    @Test
    fun testDivision() {
        assertEquals("5", CalculatorEngine.evaluate("20/4"))
        assertEquals("2.5", CalculatorEngine.evaluate("5/2"))
        assertEquals("0.25", CalculatorEngine.evaluate("1/4"))
    }


    // =========================================================
    // OPERATOR PRECEDENCE & PARENTHESES TESTS
    // =========================================================

    @Test
    fun testOperatorPrecedence() {
        assertEquals("14", CalculatorEngine.evaluate("2+3*4"))
        assertEquals("20", CalculatorEngine.evaluate("(2+3)*4"))
        assertEquals("10", CalculatorEngine.evaluate("100/10*1"))
    }


    // =========================================================
    // POWER (EXPONENT) TESTS
    // =========================================================

    @Test
    fun testPower() {
        assertEquals("8", CalculatorEngine.evaluate("2^3"))
        assertEquals("81", CalculatorEngine.evaluate("3^4"))
        assertEquals("4", CalculatorEngine.evaluate("16^0.5"))
    }


    // =========================================================
    // TRIGONOMETRIC FUNCTION TESTS (DEGREES)
    // =========================================================

    @Test
    fun testSine() {
        assertEquals("1", CalculatorEngine.evaluate("sin(90)"))
        assertEquals("0", CalculatorEngine.evaluate("sin(0)"))
        assertEquals("0.5", CalculatorEngine.evaluate("sin(30)"))
    }

    @Test
    fun testCosine() {
        assertEquals("1", CalculatorEngine.evaluate("cos(0)"))
        assertEquals("0.5", CalculatorEngine.evaluate("cos(60)"))
        assertEquals("0", CalculatorEngine.evaluate("cos(90)"))
    }

    @Test
    fun testTangent() {
        assertEquals("1", CalculatorEngine.evaluate("tan(45)"))
        assertEquals("0", CalculatorEngine.evaluate("tan(0)"))
    }


    // =========================================================
    // SQUARE ROOT TESTS
    // =========================================================

    @Test
    fun testSquareRoot() {
        assertEquals("4", CalculatorEngine.evaluate("sqrt(16)"))
        assertEquals("5", CalculatorEngine.evaluate("sqrt(25)"))
        assertEquals("1.41421356", CalculatorEngine.evaluate("sqrt(2)"))
    }


    // =========================================================
    // LOGARITHMIC FUNCTION TESTS
    // =========================================================

    @Test
    fun testLog10() {
        assertEquals("2", CalculatorEngine.evaluate("log10(100)"))
        assertEquals("3", CalculatorEngine.evaluate("log10(1000)"))
        assertEquals("0", CalculatorEngine.evaluate("log10(1)"))
    }

    @Test
    fun testNaturalLog() {
        assertEquals("0", CalculatorEngine.evaluate("ln(1)"))
        assertEquals("1", CalculatorEngine.evaluate("ln(2.71828183)"))
    }


    // =========================================================
    // CONSTANTS TESTS
    // =========================================================

    @Test
    fun testPiConstant() {
        assertEquals("3.14159265", CalculatorEngine.evaluate("pi"))
        assertEquals("6.28318531", CalculatorEngine.evaluate("2*pi"))
    }


    // =========================================================
    // ERROR HANDLING & EDGE CASE TESTS
    // =========================================================

    @Test
    fun testDivisionByZero() {
        assertEquals("Error", CalculatorEngine.evaluate("10/0"))
    }

    @Test
    fun testInvalidSyntax() {
        assertEquals("Error", CalculatorEngine.evaluate("2+*3"))
        assertEquals("Error", CalculatorEngine.evaluate("sin("))
        assertEquals("Error", CalculatorEngine.evaluate("((2+3)"))
    }

    @Test
    fun testSquareRootNegativeNumber() {
        assertEquals("Error", CalculatorEngine.evaluate("sqrt(-4)"))
    }

    @Test
    fun testEmptyOrZeroExpression() {
        assertEquals("0", CalculatorEngine.evaluate(""))
        assertEquals("0", CalculatorEngine.evaluate("0"))
    }
}