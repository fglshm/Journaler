package com.fglshm.journaler.activity

import com.fglshm.journaler.R

class TodoActivity : ItemActivity() {

    override val tag: String = TodoActivity::class.java.simpleName
    override fun getLayout(): Int = R.layout.activity_todo
    override fun getActivityTitle(): Int = R.string.app_name

}