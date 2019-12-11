package com.imbaggaarm.taiduong.dbsassignment

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    private lateinit var dataList: ArrayList<ProfileLVItemVM>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


    override fun onStart() {
        super.onStart()

        setDataForListView()

        val adapter = ProfileListViewAdapter(requireActivity(), dataList)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            when(position) {
                0 -> println(dataList[position].title)
                1 -> println(dataList[position].title)
                2 -> println(dataList[position].title)
            }
        }
    }

    private fun setDataForListView() {
        dataList = ArrayList<ProfileLVItemVM>()
        dataList.add(ProfileLVItemVM("Cập nhật thông tin", R.drawable.ic_edit_black_24dp, R.drawable.ic_keyboard_arrow_right_black_24dp))
        dataList.add(ProfileLVItemVM("Xoá tài khoản", R.drawable.ic_delete_black_24dp, R.drawable.ic_keyboard_arrow_right_black_24dp))
        dataList.add(ProfileLVItemVM("Đăng xuất", R.drawable.ic_logout_24dp, R.drawable.ic_keyboard_arrow_right_black_24dp))
    }

}
