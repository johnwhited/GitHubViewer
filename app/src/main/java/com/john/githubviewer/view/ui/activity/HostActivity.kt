package com.john.githubviewer.view.ui.activity

import android.os.Bundle
import com.john.githubviewer.R
import com.john.githubviewer.view.ui.fragment.TrendingProjectsFragment
import dagger.android.support.DaggerAppCompatActivity

class HostActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_host)
        setStartupFragment()
    }

    private fun setStartupFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fl_fragment_holder, TrendingProjectsFragment.newInstance()).commit()
    }
}
