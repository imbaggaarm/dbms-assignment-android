package com.imbaggaarm.taiduong.dbsassignment.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.imbaggaarm.taiduong.dbsassignment.R

/**
 * A simple [Fragment] subclass.
 */
class MyCoursesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_courses, container, false)
    }

}
