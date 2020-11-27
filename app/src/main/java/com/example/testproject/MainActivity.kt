package com.example.testproject

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.appbar.AppBarLayout
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
        shoe2Layout.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager,"bottom sheet fragment")
        }
        shoe3Layout.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager,"bottom sheet fragment")
        }
        shoe4Layout.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager,"bottom sheet fragment")
        }
        shoe5Layout.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager,"bottom sheet fragment")
        }

        //settingUpCollapsingToolbar

        var isShow = true
        var scrollRange = -1

        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
            if (scrollRange == -1){
                scrollRange = barLayout?.totalScrollRange!!
            }
            if (scrollRange + verticalOffset == 0){
                search_black_icon.visibility = View.VISIBLE
                more_icon_black.visibility = View.VISIBLE
                chevron_left_toolbar.visibility = View.VISIBLE
                viewInToolbar.visibility = View.VISIBLE
                isShow = true
            } else if (isShow){
                search_black_icon.visibility = View.INVISIBLE
                more_icon_black.visibility = View.INVISIBLE
                chevron_left_toolbar.visibility = View.INVISIBLE
                viewInToolbar.visibility = View.INVISIBLE
                isShow = false
            }
        })
    }

    private fun lineThroughPreviousAmount() {
        previout_amount.paintFlags = previout_amount.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }
}