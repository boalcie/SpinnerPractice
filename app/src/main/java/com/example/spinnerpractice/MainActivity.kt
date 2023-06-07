package com.example.spinnerpractice

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.ComponentActivity
import com.example.spinnerpractice.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var selectedColor: ColorObject


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadcolorSpinner()
    }


    private fun loadcolorSpinner() {
        selectedColor = ColorList().defaultColor
        binding.colorSpinner.apply {
            adapter = ColorSpinnerAdapter(applicationContext, ColorList().basicColor())
            setSelection(ColorList().colorPosition(selectedColor), false)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener
            {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long)
                {
                    selectedColor = ColorList().basicColor()[position]
                    binding.colorTextView.setTextColor(Color.parseColor(selectedColor.Name))
                }

                override fun onNothingSelected(p0: AdapterView<*>?){}
                }
            }
        }
    }
