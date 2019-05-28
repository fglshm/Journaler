package com.fglshm.journaler.navigation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.LinearLayout
import com.fglshm.journaler.R

class NavigationDrawerAdapter(
    private val ctx: Context,
    private val items: List<NavigationDrawerItem>
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(ctx)
        var view = convertView
        if (view == null) {
            view = inflater.inflate(
                R.layout.adapter_navigation_drawer, null
            ) as LinearLayout
        }

        val item = items[position]
        val title = view.findViewById<Button>(R.id.drawer_item)
        title.text = item.title
        title.setOnClickListener {
            item.onClick.run()
        }
        return view
    }

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = 0L

    override fun getCount(): Int = items.size

}