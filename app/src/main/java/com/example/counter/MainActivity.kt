package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonInc = findViewById<Button>(R.id.incValue)
        val currentValueText = findViewById<TextView>(R.id.currentValue)
        val incValueText = findViewById<TextView>(R.id.textView3)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        var counter = 0;
        var inc =0;
        incValueText.text ="Увеличивать каждый раз на: 0"
        currentValueText.text = "Текущее значение: $counter"
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                incValueText.text = "Увеличивать каждый раз на: "+seekBar?.progress.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {    }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                incValueText.text = "Увеличивать каждый раз на: "+seekBar?.progress.toString()
            }
        })
        buttonInc.setOnClickListener{
            counter += seekBar.progress
            currentValueText.text = "Текущее значение: $counter"
        }
    }
}