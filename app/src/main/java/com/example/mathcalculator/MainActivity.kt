package com.example.mathcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNumber = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if(isNewOp)
            findViewById<Button>(R.id.editText).setText("")

        isNewOp = false


        var buclick = findViewById<Button>(R.id.editText).text.toString()
        var buselect = view as Button
        when(buselect.id){
            R.id.bu1 -> {buclick += "1"}
            R.id.bu2 -> {buclick += "2"}
            R.id.bu3 -> {buclick += "3"}
            R.id.bu4 -> {buclick += "4"}
            R.id.bu5 -> {buclick += "5"}
            R.id.bu6 -> {buclick += "6"}
            R.id.bu7 -> {buclick += "7"}
            R.id.bu8 -> {buclick += "8"}
            R.id.bu9 -> {buclick += "9"}
            R.id.bu0 -> {buclick += "0"}
            R.id.buDot -> {buclick += "."}
            R.id.buPlusMinus -> {buclick = "-$buclick"}

        }
        findViewById<Button>(R.id.editText).setText(buclick)
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = findViewById<Button>(R.id.editText).text.toString()
        var buselect = view as Button
        when(buselect.id){
            R.id.buMultiply -> {op = "*"}
            R.id.buPlus -> {op = "+"}
            R.id.buMinus -> {op = "-"}
            R.id.buDivide -> {op = "/"}
        }
    }

    fun equalEvent(view: View) {
        var newnumber = findViewById<Button>(R.id.editText).text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNumber.toDouble() + newnumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newnumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newnumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newnumber.toDouble()}
        }
        findViewById<Button>(R.id.editText).setText(result.toString())
    }

    fun acEvent(view: View) {
        findViewById<Button>(R.id.editText).setText("0")
        isNewOp = true
    }

    fun percentEvent(view: View) {
        var no = findViewById<Button>(R.id.editText).text.toString().toDouble()/100
        findViewById<Button>(R.id.editText).setText(no.toString())
        isNewOp = true
    }
}