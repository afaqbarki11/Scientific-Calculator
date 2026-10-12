package com.example.mycalculator

import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.function.Function as Exp4jFunction
import java.util.Locale
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan

object CalculatorEngine {

    fun evaluate(expressionText: String): String {
        if (expressionText.isEmpty() || (expressionText == "0")) {
            return "0"
        }

        return try {
            val sinFunction = object : Exp4jFunction("sin", 1) {
                override fun apply(vararg args: Double): Double {
                    return sin(Math.toRadians(args[0]))
                }
            }

            val cosFunction = object : Exp4jFunction("cos", 1) {
                override fun apply(vararg args: Double): Double {
                    return cos(Math.toRadians(args[0]))
                }
            }

            val tanFunction = object : Exp4jFunction("tan", 1) {
                override fun apply(vararg args: Double): Double {
                    return tan(Math.toRadians(args[0]))
                }
            }

            val sqrtFunction = object : Exp4jFunction("sqrt", 1) {
                override fun apply(vararg args: Double): Double {
                    return sqrt(args[0])
                }
            }

            val log10Function = object : Exp4jFunction("log10", 1) {
                override fun apply(vararg args: Double): Double {
                    return log10(args[0])
                }
            }

            val lnFunction = object : Exp4jFunction("ln", 1) {
                override fun apply(vararg args: Double): Double {
                    return ln(args[0])
                }
            }

            val expression = ExpressionBuilder(expressionText)
                .function(sinFunction)
                .function(cosFunction)
                .function(tanFunction)
                .function(sqrtFunction)
                .function(log10Function)
                .function(lnFunction)
                .build()

            val result = expression.evaluate()

            if (result.isNaN() || result.isInfinite()) {
                "Error"
            } else if ((result % 1.0) == 0.0) {
                result.toLong().toString()
            } else {
                String.format(Locale.US, "%.8f", result)
                    .trimEnd('0')
                    .trimEnd('.')
            }
        } catch (_: Exception) {
            "Error"
        }
    }
}