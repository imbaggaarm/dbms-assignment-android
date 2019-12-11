package com.imbaggaarm.taiduong.dbsassignment

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_course_detail.*

class CourseDetailActivity : AppCompatActivity() {

    private val INDEX_HOME = 0
    private val INDEX_LESSONS = 1
    private val INDEX_FORUMS = 2
    private val INDEX_GRADES = 3
    private val INDEX_COMMENTS = 4

    private lateinit var dataList: ArrayList<Any>
    private var selectedIndex = INDEX_HOME

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        title = ""

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()


        btnHome.setOnClickListener { v ->
            unSelectedBtn(selectedIndex)
            selectedIndex = INDEX_HOME
            onBtnSelected(v as Button)
        }

        btnLessons.setOnClickListener { v ->
            unSelectedBtn(selectedIndex)
            selectedIndex = INDEX_LESSONS
            onBtnSelected(v as Button)
        }

        btnForums.setOnClickListener { v ->
            unSelectedBtn(selectedIndex)
            selectedIndex = INDEX_FORUMS
            onBtnSelected(v as Button)
        }

        btnGrades.setOnClickListener { v ->
            unSelectedBtn(selectedIndex)
            selectedIndex = INDEX_GRADES
            onBtnSelected(v as Button)
        }

        btnComments.setOnClickListener { v ->
            unSelectedBtn(selectedIndex)
            selectedIndex = INDEX_COMMENTS
            onBtnSelected(v as Button)
        }

        onBtnSelected(btnHome as Button)
    }

    private fun reloadRV() {
        when(selectedIndex) {
            INDEX_COMMENTS -> {
                setCommentData()
                val adapter = CommentRVAdapter(this, dataList as ArrayList<CommentRVItemVM>)
                recyclerView.adapter = adapter
            }
            INDEX_HOME -> {
                setCourseInfoData()
                val adapter = CourseInfoRVAdapter(this, dataList as ArrayList<CourseInfoRVItemVM>)
                recyclerView.adapter = adapter
            }
        }
    }

    private fun setCommentData() {
        dataList = ArrayList()
        dataList.add(
            CommentRVItemVM(
                "Tài Dương",
                "url",
                "Bài giảng khá hay",
                "1 giờ trước")
        )

        dataList.add(
            CommentRVItemVM(
                "Công Anh",
                "url",
                "Bài giảng tàm tạm thôi",
                "23:08")
        )

        dataList.add(
            CommentRVItemVM(
                "Tài Dương",
                "url",
                "Bài giảng khá hay",
                "1 giờ trước")
        )

        dataList.add(
            CommentRVItemVM(
                "Tài Dương",
                "url",
                "Bài giảng khá hay",
                "1 giờ trước")
        )

        dataList.add(
            CommentRVItemVM(
                "Tài Dương",
                "url",
                "Bài giảng khá hay",
                "1 giờ trước")
        )
        dataList.addAll(dataList)
        dataList.addAll(dataList)
    }

    private fun setCourseInfoData() {
        val text = resources.getString(R.string.course_detail_placeholder)
        val info = CourseInfoRVItemVM(text)
        dataList = ArrayList()
        dataList.add(info)
    }

    private fun onBtnSelected(btn: Button) {
        setBtnAppearance(btn, true)
        if (selectedIndex == INDEX_COMMENTS) {
            vInputMessageBar.visibility = View.VISIBLE
            recyclerView.visibility = View.VISIBLE
        } else {
            vInputMessageBar.visibility = View.GONE
            recyclerView.visibility = if (selectedIndex == INDEX_HOME) View.VISIBLE else View.INVISIBLE
        }
        reloadRV()
    }

    private fun setBtnAppearance(btn: Button, isHighlighted: Boolean) {
        val color = if (isHighlighted) ContextCompat.getColor(this, R.color.colorPrimary) else Color.WHITE
        btn.setTextColor(color)
    }

    private fun unSelectedBtn(index: Int) {
        val btn = when(index) {
            INDEX_HOME -> btnHome
            INDEX_COMMENTS -> btnComments
            INDEX_GRADES -> btnGrades
            INDEX_FORUMS -> btnForums
            INDEX_LESSONS -> btnLessons
            else -> {
                return
            }
        }

        setBtnAppearance(btn, false)
    }

}
