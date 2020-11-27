package com.example.testproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.SpinnerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testproject.custom.CostAdapter
import com.example.testproject.custom.SizeAdapter
import com.example.testproject.pojoClasses.Cost
import com.example.testproject.pojoClasses.Size
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_fragment.*
import kotlinx.android.synthetic.main.bottom_sheet_fragment.view.*
import kotlin.math.cos


class BottomSheetFragment : BottomSheetDialogFragment() {

    lateinit var sizeAdapter: SizeAdapter
    lateinit var list: MutableList<Size>
    var itemQuantity: Int = 1
    private val images = intArrayOf(
        R.drawable.cover_image,
        R.drawable.image2,
        R.drawable.cover_image,
        R.drawable.image2,
        R.drawable.cover_image
    )
    private var imageIndex: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = ArrayList()
        sizeAdapter = SizeAdapter(context!!, list)

        view.sizeRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = sizeAdapter
        }

        addItem.setOnClickListener {
            itemQuantity++
            tv_quantity.text = itemQuantity.toString()
        }

        removeItem.setOnClickListener {
            if (itemQuantity > 1) {
                itemQuantity--
                tv_quantity.text = itemQuantity.toString()
            }
        }

        tv_quantity.text = itemQuantity.toString()

        addSizesToSizeList()

        //imageSwitcher
        imageSwitcher?.setFactory {
            val imgView = ImageView(context)
            imgView.scaleType = ImageView.ScaleType.FIT_XY
            imgView
        }

        imageSwitcher?.setImageResource(images[imageIndex])


        prev_imsg_layout.setOnClickListener {
            if (imageIndex - 1 >= 0) {
                imageIndex -= 1
                imageSwitcher?.setImageResource(images[imageIndex])
                if (imageIndex == 0) {
                    prev_imsg_layout.visibility = View.INVISIBLE
                    next_img_layout.visibility = View.VISIBLE
                } else {
                    prev_imsg_layout.visibility = View.VISIBLE
                    next_img_layout.visibility = View.VISIBLE
                }
            }
        }

        next_img_layout.setOnClickListener {
            if (imageIndex + 1 < images.size) {
                imageIndex += 1
                imageSwitcher?.setImageResource(images[imageIndex])
                if (imageIndex == images.size - 1) {
                    next_img_layout.visibility = View.INVISIBLE
                    prev_imsg_layout.visibility = View.VISIBLE
                } else {
                    next_img_layout.visibility = View.VISIBLE
                    prev_imsg_layout.visibility = View.VISIBLE
                }
            }
        }

        if (imageIndex == 0) {
            prev_imsg_layout.visibility = View.INVISIBLE
        }

        img1Layout.setOnClickListener {
            imageSwitcher?.setImageResource(images[0])
            imageIndex = 0
            prev_imsg_layout.visibility = View.INVISIBLE
            next_img_layout.visibility = View.VISIBLE
        }
        img2Layout.setOnClickListener {
            imageIndex = 1
            imageSwitcher?.setImageResource(images[1])
            next_img_layout.visibility = View.VISIBLE
            prev_imsg_layout.visibility = View.VISIBLE
        }
        img3Layout.setOnClickListener {
            imageIndex = 2
            imageSwitcher?.setImageResource(images[2])
            next_img_layout.visibility = View.VISIBLE
            prev_imsg_layout.visibility = View.VISIBLE
        }
        img4Layout.setOnClickListener {
            imageIndex = 3
            imageSwitcher?.setImageResource(images[3])
            next_img_layout.visibility = View.VISIBLE
            prev_imsg_layout.visibility = View.VISIBLE
        }
        img5Layout.setOnClickListener {
            imageIndex = 4
            imageSwitcher?.setImageResource(images[4])
            next_img_layout.visibility = View.INVISIBLE
            prev_imsg_layout.visibility = View.VISIBLE
        }


        //spinner
        setUpSpinner()


    }

    private fun setUpSpinner() {

        val costList: MutableList<Cost> = mutableListOf()
        costList.add(Cost("Cost: BDT. 4000"))
        costList.add(Cost("Cost: BDT. 6000"))
        costList.add(Cost("Cost: BDT. 8000"))

        val adapter = CostAdapter(context!!,costList)
        spinner.adapter = adapter
    }

    private fun addSizesToSizeList() {
        list.add(Size("S"))
        list.add(Size("M"))
        list.add(Size("X"))
        list.add(Size("XL"))

        sizeAdapter.notifyDataSetChanged()
    }
}