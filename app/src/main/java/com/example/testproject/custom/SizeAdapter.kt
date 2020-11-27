package com.example.testproject.custom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.pojoClasses.Size
import kotlinx.android.synthetic.main.show_size_demo.view.*

class SizeAdapter(val context: Context, val sizeList: MutableList<Size>) :
    RecyclerView.Adapter<SizeAdapter.SizeViewHolder>() {

    var selectedItem : Int = -1

    inner class SizeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeViewHolder {

        return SizeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.show_size_demo,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return sizeList.size
    }

    override fun onBindViewHolder(holder: SizeViewHolder, position: Int) {

        holder.itemView.tv_size.text = sizeList[position].sizeName
        holder.itemView.sizeLayout.setOnClickListener {
            selectedItem = position
            notifyDataSetChanged()
        }

        if(selectedItem == position){
            holder.itemView.sizeLayout.setBackgroundResource(R.drawable.size_layout_bg_after_press)
        }
        else{
            holder.itemView.sizeLayout.setBackgroundResource(R.drawable.size_layout_bg)
        }
    }


}