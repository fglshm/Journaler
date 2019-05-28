package com.fglshm.journaler.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.fglshm.journaler.R
import com.fglshm.journaler.fragment.ItemsFragment
import com.fglshm.journaler.navigation.NavigationDrawerAdapter
import com.fglshm.journaler.navigation.NavigationDrawerItem
import kotlinx.android.synthetic.main.activity_header.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override val tag: String = MainActivity::class.java.simpleName
    override fun getLayout(): Int = R.layout.activity_main
    override fun getActivityTitle(): Int = R.string.app_name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pager.adapter = ViewPagerAdapter(supportFragmentManager)

        val menuItems = mutableListOf<NavigationDrawerItem>()

        val today = NavigationDrawerItem(
            resources.getString(R.string.today),
            Runnable {
                pager.setCurrentItem(0, true)
            }
        )

        val next7Days = NavigationDrawerItem(
            resources.getString(R.string.next_seven_days),
            Runnable {
                pager.setCurrentItem(1, true)
            }
        )

        val todos = NavigationDrawerItem(
            resources.getString(R.string.todos),
            Runnable {
                pager.setCurrentItem(2, true)
            }
        )

        val notes = NavigationDrawerItem(
            resources.getString(R.string.notes),
            Runnable {
                pager.setCurrentItem(3, true)
            }
        )

        menuItems.add(today)
        menuItems.add(next7Days)
        menuItems.add(todos)
        menuItems.add(notes)

        val navigationDrawerAdapter = NavigationDrawerAdapter(
            this,
            menuItems
        )
        left_drawer.adapter = navigationDrawerAdapter
    }

    private class ViewPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {
        override fun getItem(position: Int): Fragment = ItemsFragment()
        override fun getCount(): Int = 5
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.drawing_menu -> {
                drawer_layout.openDrawer(GravityCompat.START)
                true
            }
            R.id.options_menu -> {
                Log.d(tag, "option menu")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
