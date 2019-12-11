package com.imbaggaarm.taiduong.dbsassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.imbaggaarm.taiduong.dbsassignment.viewmodels.ProfileLVItemVM
import com.imbaggaarm.taiduong.dbsassignment.R

class ProfileListViewAdapter(private val context: Context,
                             private val dataSource: ArrayList<ProfileLVItemVM>): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.count()
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var rowView = convertView
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.profile_lv_item, null)
        }

        val leftIcon = rowView!!.findViewById<ImageView>(R.id.imgVLeftIcon)
        val rightIcon = rowView!!.findViewById<ImageView>(R.id.imgVRightIcon)
        val txtTitle = rowView!!.findViewById<TextView>(R.id.txtTitle)

        val vm = getItem(position) as ProfileLVItemVM
        txtTitle.text = vm.title
        leftIcon.setImageResource(vm.leftIconID)
        rightIcon.setImageResource(vm.rightIconID)
        return rowView!!
    }
}