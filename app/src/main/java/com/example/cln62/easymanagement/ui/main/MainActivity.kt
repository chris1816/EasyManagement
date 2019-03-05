package com.example.cln62.easymanagement.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import com.example.cln62.easymanagement.R
import com.example.cln62.easymanagement.ui.project.ProjectListFragment
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

    private val OnNavigationItemSelectedListener
            = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.projects -> {
                val fragment = ProjectListFragment()
                fragmentManager.beginTransaction().add(R.id.mainActivity, fragment).addToBackStack(null).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.employeeList -> {
/*                val subTaskListFrag = EmployeeListFragment()
                fragmentManager.beginTransaction().add(R.id.mainActivity, subTaskListFrag)
                    .addToBackStack(null).commit()*/
                return@OnNavigationItemSelectedListener true
            }
            R.id.logout -> {
//                startActivity(intentFor<LoginActivity>())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
