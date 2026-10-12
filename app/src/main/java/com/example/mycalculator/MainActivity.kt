package com.example.mycalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private lateinit var tvExpression: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplay = findViewById(R.id.tvDisplay)
        tvExpression = findViewById(R.id.tvExpression)

        // =====================================================
        // NUMBER BUTTONS
        // =====================================================

        val numberButtons = listOf(
            R.id.btn0,
            R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn7,
            R.id.btn8,
            R.id.btn9
        )

        numberButtons.forEach { id ->

            findViewById<Button>(id).setOnClickListener {

                appendText(
                    (it as Button).text.toString()
                )
            }
        }


        // =====================================================
        // DOT
        // =====================================================

        findViewById<Button>(R.id.btnDot).setOnClickListener {
            appendText(".")
        }


        // =====================================================
        // BASIC OPERATORS
        // =====================================================

        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            appendText("+")
        }

        findViewById<Button>(R.id.btnMinus).setOnClickListener {
            appendText("-")
        }

        findViewById<Button>(R.id.btnMultiply).setOnClickListener {
            appendText("*")
        }

        findViewById<Button>(R.id.btnDivide).setOnClickListener {
            appendText("/")
        }


        // =====================================================
        // BRACKETS
        // =====================================================

        findViewById<Button>(R.id.btnOpenBracket).setOnClickListener {
            appendText("(")
        }

        findViewById<Button>(R.id.btnCloseBracket).setOnClickListener {
            appendText(")")
        }


        // =====================================================
        // POWER
        // =====================================================

        findViewById<Button>(R.id.btnPower).setOnClickListener {
            appendText("^")
        }


        // =====================================================
        // SIN
        // =====================================================

        findViewById<Button>(R.id.btnSin).setOnClickListener {
            appendText("sin(")
        }


        // =====================================================
        // COS
        // =====================================================

        findViewById<Button>(R.id.btnCos).setOnClickListener {
            appendText("cos(")
        }


        // =====================================================
        // TAN
        // =====================================================

        findViewById<Button>(R.id.btnTan).setOnClickListener {
            appendText("tan(")
        }


        // =====================================================
        // SQUARE ROOT
        // =====================================================

        findViewById<Button>(R.id.btnSqrt).setOnClickListener {
            appendText("sqrt(")
        }


        // =====================================================
        // PI
        // =====================================================

        findViewById<Button>(R.id.btnPi).setOnClickListener {
            appendText("pi")
        }


        // =====================================================
        // LOG BASE 10
        // =====================================================

        findViewById<Button>(R.id.btnLog).setOnClickListener {
            appendText("log10(")
        }


        // =====================================================
        // NATURAL LOG
        // =====================================================

        findViewById<Button>(R.id.btnLn).setOnClickListener {
            appendText("ln(")
        }


        // =====================================================
        // CLEAR
        // =====================================================

        findViewById<Button>(R.id.btnClear).setOnClickListener {

            tvDisplay.text = "0"
            tvExpression.text = ""
        }


        // =====================================================
        // BACKSPACE
        // =====================================================

        findViewById<Button>(R.id.btnBackspace).setOnClickListener {

            val current = tvDisplay.text.toString()

            if (current == "Error") {

                tvDisplay.text = "0"
                tvExpression.text = ""

            } else if (current.length > 1) {

                tvDisplay.text =
                    current.substring(
                        0,
                        current.length - 1
                    )

            } else {

                tvDisplay.text = "0"
            }
        }


        // =====================================================
        // EQUAL
        // =====================================================

        findViewById<Button>(R.id.btnEqual).setOnClickListener {

            calculate()
        }
    }


    // =========================================================
    // APPEND TEXT
    // =========================================================

    private fun appendText(value: String) {

        val current = tvDisplay.text.toString()

        if (current == "Error" || current == "0") {

            tvDisplay.text = value

        } else {

            tvDisplay.append(value)
        }
    }


    // =========================================================
    // CALCULATE
    // =========================================================

    private fun calculate() {

        val expressionText = tvDisplay.text.toString()

        if (expressionText.isEmpty() || expressionText == "0") {
            return
        }

        tvExpression.text = expressionText
        tvDisplay.text = CalculatorEngine.evaluate(expressionText)
    }
}