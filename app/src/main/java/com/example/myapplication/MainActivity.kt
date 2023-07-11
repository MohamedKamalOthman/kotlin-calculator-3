package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Number Buttons*/

        tvOne.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        tvTwo.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        tvThree.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        tvFour.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        tvFive.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        tvSix.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        tvSeven.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        tvEight.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        tvNine.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        tvZero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        /*Operators*/

        tvPlus.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        tvMinus.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        tvMul.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        tvDot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        tvDiv.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        tvAC.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvplusminus.setOnClickListener {
            var text = tvExpression.text.toString()
            if (text.isNotEmpty()) {
                text = text.reversed()
                text = text.drop(1)
                text = text.reversed()
                tvExpression.text = text
            }

        }

        tvEquals.setOnClickListener {
            try {
                val text = tvExpression.text.toString()
                val expression = ExpressionBuilder(text).build()

                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    tvResult.text = longResult.toString()
                } else {
                    tvResult.text = result.toString()
                }
            } catch (E: Exception) {
                tvResult.text = "Invalid Expression"
            }
        }


    }

    /*Function to calculate the expressions using expression builder library*/

    fun evaluateExpression(string: String, clear: Boolean) {
        if (clear) {
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }
}