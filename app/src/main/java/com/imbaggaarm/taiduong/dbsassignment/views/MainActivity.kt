package com.imbaggaarm.taiduong.dbsassignment.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.imbaggaarm.taiduong.dbsassignment.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.name

    private val currentSelectedMenuItemId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        bottomNavigationBar.selectedItemId =
            R.id.profile
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.profile -> {
                title = "Cá nhân"
                val fragment =
                    ProfileFragment()
                openFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.mycourses -> {
                title = "Của tôi"
                val fragment =
                    MyCoursesFragment()
                openFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.courses -> {
                title = "Khoá học"
                val fragment =
                    CoursesFragment()
                openFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
