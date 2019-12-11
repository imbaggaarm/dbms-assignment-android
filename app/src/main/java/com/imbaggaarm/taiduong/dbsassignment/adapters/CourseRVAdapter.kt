package com.imbaggaarm.taiduong.dbsassignment.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imbaggaarm.taiduong.dbsassignment.views.CourseDetailActivity
import com.imbaggaarm.taiduong.dbsassignment.viewmodels.CourseRVItemVM
import com.imbaggaarm.taiduong.dbsassignment.R
import kotlinx.android.synthetic.main.course_rv_item.view.*

class CourseRVAdapter(private val context: Context,
                      private val dataSource: ArrayList<CourseRVItemVM>): RecyclerView.Adapter<CourseRVAdapter.CourseHolder>() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItemCount() = dataSource.count()

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseHolder {
        val view = inflater.inflate(R.layout.course_rv_item, parent, false)
        return CourseHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: CourseHolder, position: Int) {
        val course = dataSource[position]
        holder.bindCourse(course)
    }

    class CourseHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var course: CourseRVItemVM? = null
        private val context: Context
        init {
            v.setOnClickListener(this)
            context = v.context
        }

        override fun onClick(v: View?) {
            val intent = Intent(context, CourseDetailActivity::class.java)
            context.startActivity(intent)
        }

        fun bindCourse(course: CourseRVItemVM) {
            this.course = course
            view.imgVPicture.setImageResource(R.drawable.small_logo)
            view.txtTitle.text = course.title
            view.txtInstitution.text = course.institution
        }

    }
}