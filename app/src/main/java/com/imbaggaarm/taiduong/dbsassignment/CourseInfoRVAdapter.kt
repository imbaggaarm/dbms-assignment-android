package com.imbaggaarm.taiduong.dbsassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.course_detail_info_item.view.*

class CourseInfoRVAdapter(private val context: Context,
                          private val dataSource: ArrayList<CourseInfoRVItemVM>): RecyclerView.Adapter<CourseInfoRVAdapter.CourseDetailViewHolder>() {


    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getItemCount(): Int = dataSource.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseDetailViewHolder {
        return CourseDetailViewHolder(inflater.inflate(R.layout.course_detail_info_item, parent, false))
    }

    override fun onBindViewHolder(holder: CourseDetailViewHolder, position: Int) {
        val info = dataSource[position]
        holder.bindInfo(info)
    }

    class CourseDetailViewHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
        private val view: View = v
        private var info: CourseInfoRVItemVM? = null
        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            println("On clicked")
        }

        fun bindInfo(info: CourseInfoRVItemVM) {
            this.info = info
            view.txtInfo.text = info.text
        }
    }
}
