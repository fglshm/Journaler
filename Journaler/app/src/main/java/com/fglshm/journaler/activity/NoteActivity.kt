package com.fglshm.journaler.activity

import com.fglshm.journaler.R

class NoteActivity : ItemActivity() {

    override val tag: String = NoteActivity::class.java.simpleName
    override fun getLayout(): Int = R.layout.activity_note
    override fun getActivityTitle(): Int = R.string.app_name

}