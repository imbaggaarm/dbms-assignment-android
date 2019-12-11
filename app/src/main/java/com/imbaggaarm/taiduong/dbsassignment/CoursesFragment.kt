package com.imbaggaarm.taiduong.dbsassignment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_courses.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class CoursesFragment : Fragment() {

    private lateinit var dataList: ArrayList<CourseRVItemVM>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_courses, container, false)
    }

    override fun onStart() {
        super.onStart()

        setData()

        val adapter = CourseRVAdapter(requireActivity(), dataList)
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
    }

    private fun setData() {
        dataList = ArrayList<CourseRVItemVM>()
        dataList.add(
            CourseRVItemVM("Học lập trình iOS với Objective C",
            "Đại học Bách Khoa TP.HCM",
            "url")
        )

        dataList.add(CourseRVItemVM("Kĩ năng chuyên nghiệp cho kĩ sư",
            "Đại học Bách Khoa TP.HCM",
            "url"))

        dataList.add(CourseRVItemVM("Nguyên lý ngôn ngữ lập trình",
            "Đại học Bách Khoa TP.HCM",
            "url"))

        dataList.add(CourseRVItemVM("Nhập môn lập trình",
            "HCMUS",
            "url"))

        dataList.add(CourseRVItemVM("Phân tích và thiết kế hệ thống",
            "HCMUT",
            "url"))

        dataList.add(CourseRVItemVM("Nhập môn kỹ thuật",
            "HCMUS",
            "url"))

        dataList.add(CourseRVItemVM("Quản trị kinh doanh cho kĩ sư",
            "HCMIU",
            "url"))
    }

}
