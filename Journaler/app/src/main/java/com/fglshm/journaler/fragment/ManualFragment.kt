package com.fglshm.journaler.fragment

import com.fglshm.journaler.R

class ManualFragment : BaseFragment() {

    override val logTag: String = ManualFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_manual

}