package dev.lucy.calc

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var btnAdd: Button
    lateinit var btnSubtract: Button
    lateinit var btnModulus: Button
    lateinit var btnDivision: Button
    lateinit var tvResults: TextView
    lateinit var tilFirstnum: TextInputLayout
    lateinit var tilSecondnum: TextInputLayout
    lateinit var tieFirstnum: TextInputEditText
    lateinit var tieSecondnum: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnDivision = findViewById(R.id.btnDivision)
        btnModulus = findViewById(R.id.btnModulus)
        tvResults = findViewById(R.id.tvResults)
        tilFirstnum = findViewById(R.id.tilFirstnum)
        tilSecondnum = findViewById(R.id.tilSecondnum)
        tieFirstnum = findViewById(R.id.tieFirstnum)
        tieSecondnum=findViewById(R.id.tieSecondnum)
        btnAdd.setOnClickListener {
            val number1 = tieFirstnum.text.toString()
            val number2 = tieSecondnum.text.toString()
            if (number1.isBlank()) {
                tieFirstnum.setError("number is required")

                return@setOnClickListener
            } else if (number2.isBlank()) {
                tieSecondnum.setError("number is required")

                return@setOnClickListener
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                add(number1.toInt(), number2.toInt())
            }
        }
        btnSubtract.setOnClickListener {
            val number1 = tieFirstnum.text.toString()
            val number2 = tieSecondnum.text.toString()
            if (number1.isBlank()) {
                tieFirstnum.setError("number is required")

                return@setOnClickListener
            } else if (number2.isBlank()) {
                tieSecondnum.setError("number is required")

                return@setOnClickListener
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

                subtract(number1.toInt(), number2.toInt())
            }
        }

        btnModulus.setOnClickListener {
            val number1 = tieFirstnum.text.toString()
            val number2 = tieSecondnum.text.toString()
            if (number1.isBlank()) {
                tieFirstnum.setError("number is required")

                return@setOnClickListener
            } else if (number2.isBlank()) {
                tieSecondnum.setError("number is required")

                return@setOnClickListener
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

                modulus(number1.toInt(), number2.toInt())
            }
        }
        btnDivision.setOnClickListener {
            val number1 = tieFirstnum.text.toString()
            val number2 = tieSecondnum.text.toString()
            if (number1.isBlank()) {
                btnDivision.setError("number is required")

                return@setOnClickListener
            } else if (number2.isBlank()) {
                btnDivision.setError("number is required")
                return@setOnClickListener
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

                division(number1.toInt(), number2.toInt())
            }
        }


    }

    fun add(number1: Int, number2: Int) {
        val result = number1 + number2
        tvResults.text = result.toString()
    }

    fun subtract(number1: Int, number2: Int) {
        val result = number1 - number2
        tvResults.text = result.toString()
    }

    fun modulus(number1: Int, number2: Int) {
        val result = number1 % number2
        tvResults.text = result.toString()
    }

    fun division(number1: Int, number2: Int) {
        val result = number1 / number2
        tvResults.text = result.toString()
    }

}