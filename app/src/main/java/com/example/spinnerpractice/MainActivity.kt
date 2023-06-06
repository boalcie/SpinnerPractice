package com.example.spinnerpractice

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.spinnerpractice.databinding.ActivityMainBinding
import com.example.spinnerpractice.ui.theme.SpinnerPracticeTheme

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
                }

                override fun onNothingSelected(p0: AdapterView<*>?){}
                }
            }
        }
    }
