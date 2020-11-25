package com.example.testproject

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lineThroughPreviousAmount();

        val bottomSheetFragment = BottomSheetFragment()
        shoe1Layout.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager,"bottom sheet fragment")
        }
    }

    private fun lineThroughPreviousAmount() {
        previout_amount.paintFlags = previout_amount.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }
}