package com.amartadev.fundamentalbarvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtHeight: EditText
    private lateinit var edtWidht: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnResult: Button
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar!!.title = "Calculator Volume"
        actionBar.setDisplayHomeAsUpEnabled(true)

        edtHeight = findViewById(R.id.edit_tinggi)
        edtWidht = findViewById(R.id.edit_lebar)
        edtLength = findViewById(R.id.edit_lenght)
        btnResult = findViewById(R.id.btn_hasil)
        result = findViewById(R.id.tv_result)

        btnResult.setOnClickListener(this)

        if (savedInstanceState != null) {
            val res = savedInstanceState.getString(STATE_RESAULT) as String
            result.text = res
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESAULT, result.text.toString())
    }

    companion object {
        private const val STATE_RESAULT = "state_result"
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_hasil) {
            val inputLenght = edtLength.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()
            val inputWidht = edtWidht.text.toString().trim()

            var isEmptyFields = false

            if (inputLenght.isEmpty()) {
                isEmptyFields = true
                edtLength.error = "panjang kosong"
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                edtHeight.error = "tinggi kosong"
            }
            if (inputWidht.isEmpty()) {
                isEmptyFields = true
                edtWidht.error = "lebar kosong"
            }

            if (!isEmptyFields) {
                val volume = inputLenght.toDouble() * inputWidht.toDouble() * inputHeight.toDouble()
                result.text = volume.toString()
            }
        }
    }
}
