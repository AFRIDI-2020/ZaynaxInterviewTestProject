package com.example.testproject.custom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.testproject.R
import com.example.testproject.pojoClasses.Cost
import kotlinx.android.synthetic.main.spinner_layout.view.*

class CostAdapter(context: Context,costList : MutableList<Cost>) : ArrayAdapter<Cost>(context,0,costList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup) : View{

        val cost = getItem(position)

        val view = LayoutInflater.from(context).inflate(R.layout.spinner_layout,parent, false)

        view.spinner_text.text = cost?.mCost

        return view
    }
}