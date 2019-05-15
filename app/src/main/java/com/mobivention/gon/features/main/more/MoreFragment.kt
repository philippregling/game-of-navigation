package com.mobivention.gon.features.main.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobivention.gon.features.BaseFragment
import com.mobivention.gon.features.main.license.LicenseDialogFragment
import com.mobivention.myapplication.R
import kotlinx.android.synthetic.main.fragment_more.*

class MoreFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        more_open_license?.setOnClickListener {
            val dialogFragment = LicenseDialogFragment()
            dialogFragment.show(activity?.supportFragmentManager, "TAG")
        }
    }

}